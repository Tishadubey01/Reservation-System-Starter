package flight.reservation.order;

import flight.reservation.payment.PaymentStrategy;

public class PaymentHandler {
	Order order;
	Handler nextHandler;

	public void setNext(Handler h) {
		this.nextHandler = h;
	}

	public boolean handle(Order order) {
		this.order = order;
		return Pay(order.getPaymentStrategy());
	}

	public boolean Pay(PaymentStrategy paymentMethod){
			boolean isPaid=paymentMethod.Pay(order.getPrice());
			if (isPaid) {
					order.setClosed();
			}
			return isPaid;
	}
}
