package flight.reservation.order;

import java.nio.channels.NetworkChannel;
import java.util.Date;

import flight.reservation.payment.CreditCard;
import flight.reservation.payment.Paypal;

public class ProcessingHandler implements Handler{

	Order order;
	Handler nextHandler;

	public void setNext(Handler handler) {
		this.nextHandler = handler;
	}

	public boolean handle(Order order) {
		this.order = order;
		if (order.getPaymentStrategy().getClass() != CreditCard.class) {
			CreditCard card = (CreditCard) order.getPaymentStrategy();
			return processOrderWithCreditCard(card);
		} else {
			String password = "";
			// get password from UI
			return processOrderWithPayPal(order.getCustomer().getEmail(), password);
		}
	}

	public boolean processOrderWithCreditCardDetail(String number, Date expirationDate, String cvv) throws IllegalStateException {
			CreditCard creditCard = new CreditCard(number, expirationDate, cvv);
			return processOrderWithCreditCard(creditCard);
	}

	public boolean processOrderWithCreditCard(CreditCard creditCard) throws IllegalStateException {
			if (order.isClosed()) {
					// Payment is already proceeded
					return true;
			}
			// validate payment information
			if (!cardIsPresentAndValid(creditCard)) {
					throw new IllegalStateException("Payment information is not set or not valid.");
			}
			return nextHandler.handle(order);
	}

	private boolean cardIsPresentAndValid(CreditCard card) {
			return card != null && card.isValid();
	}

	public boolean processOrderWithPayPal(String email, String password) throws IllegalStateException {
			if (order.isClosed()) {
					// Payment is already proceeded
					return true;
			}
			// validate payment information
			if (email == null || password == null || !email.equals(Paypal.DATA_BASE.get(password))) {
					throw new IllegalStateException("Payment information is not set or not valid.");
			}
			return nextHandler.handle(order);
	}
}
