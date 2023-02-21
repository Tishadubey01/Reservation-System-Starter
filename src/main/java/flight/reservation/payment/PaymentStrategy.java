package flight.reservation.payment;

public interface PaymentStrategy {
    public boolean Pay(Double amount);
}
