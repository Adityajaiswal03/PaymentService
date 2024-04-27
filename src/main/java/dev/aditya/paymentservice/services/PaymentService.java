package dev.aditya.paymentservice.services;

import com.razorpay.RazorpayException;
import dev.aditya.paymentservice.paymentgateway.PaymentGateway;
import org.springframework.stereotype.Service;
@Service
public class PaymentService {
    private PaymentGateway paymentGateway;
    PaymentService(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }
    public String initiatePayment(long orderId,String email ) throws RazorpayException {
        return paymentGateway.generatePaymentLink(orderId,email);
    }

}
