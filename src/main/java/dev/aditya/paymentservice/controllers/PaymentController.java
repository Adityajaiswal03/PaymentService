package dev.aditya.paymentservice.controllers;
import com.razorpay.RazorpayException;
import dev.aditya.paymentservice.services.PaymentService;
import dev.aditya.paymentservice.dto.InitiatePaymentRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;
    PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto requestDto) throws RazorpayException {

        return paymentService.initiatePayment(
                requestDto.getOrderId(),
                requestDto.getEmail()
        );

    }

}
