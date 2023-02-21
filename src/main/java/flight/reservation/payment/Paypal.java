package flight.reservation.payment;

import java.util.HashMap;
import java.util.Map;

public class Paypal implements PaymentStrategy{
    private String email;
    private String password;

    
    public static final Map<String, String> DATA_BASE = new HashMap<>();

    public Paypal(String email,String password){
        this.email=null;
        this.password=null;
    }
    static {
        DATA_BASE.put("amanda1985", "amanda@ya.com");
        DATA_BASE.put("qwerty", "john@amazon.eu");
    }

    @Override
    public boolean Pay(Double amount){
        System.out.println("Paying " + amount + " using PayPal.");
        return true;
    }
    

}

