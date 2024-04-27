package dev.aditya.paymentservice.paymentgateway;

import com.razorpay.RazorpayException;

public interface PaymentGateway {
    public String  generatePaymentLink(long orderId,String email) throws RazorpayException;
}
