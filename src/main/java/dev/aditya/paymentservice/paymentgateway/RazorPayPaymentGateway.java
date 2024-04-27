package dev.aditya.paymentservice.paymentgateway;
import com.razorpay.PaymentLink;
import lombok.Value;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.stereotype.Component;

@Component
public class RazorPayPaymentGateway implements PaymentGateway{

    public String generatePaymentLink(long orderId,String email) throws RazorpayException {

        RazorpayClient razorpay = new RazorpayClient("rzp_test_uZ6Ak7HJGDfZoW"," lkZLET4sy96uzQlyxIhofRd1");
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",1000);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("expire_by",1691097057);
        paymentLinkRequest.put("reference_id","1234");
        paymentLinkRequest.put("description","Payment for policy no #23456");
        JSONObject customer = new JSONObject();
        customer.put("name","+919000090000");
        customer.put("contact","Gaurav Kumar");
        customer.put("email",email);
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        paymentLinkRequest.put("callback_url","https://example-callback-url.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
        return  payment.toString();
    }
}
