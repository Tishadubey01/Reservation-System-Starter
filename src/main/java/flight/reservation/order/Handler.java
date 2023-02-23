package flight.reservation.order;

interface Handler {
	void setNext(Handler h);
	boolean handle(Order o);
}
