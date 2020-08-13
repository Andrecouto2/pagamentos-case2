package br.com.mastertech.couto.pagamentos.model.dtos;

import br.com.mastertech.couto.pagamentos.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public GetPaymentResponse toGetPaymentResponse(Payment payment) {
        GetPaymentResponse getPaymentResponse = new GetPaymentResponse();
        getPaymentResponse.setId(payment.getId());
        getPaymentResponse.setCardId(payment.getCardId());
        getPaymentResponse.setDescription(payment.getDescription());
        getPaymentResponse.setValue(payment.getValue());
        return getPaymentResponse;
    }

    public CreatePaymentResponse toCreatePaymentResponse(Payment payment) {
        CreatePaymentResponse createPaymentResponse = new CreatePaymentResponse();
        createPaymentResponse.setId(payment.getId());
        createPaymentResponse.setCardId(payment.getCardId());
        createPaymentResponse.setDescription(payment.getDescription());
        createPaymentResponse.setValue(payment.getValue());
        return createPaymentResponse;
    }

    public Payment toPayment(CreatePaymentRequest createPaymentRequest) {
        Payment payment = new Payment();
        payment.setCardId(createPaymentRequest.getCardId());
        payment.setValue(createPaymentRequest.getValue());
        payment.setDescription(createPaymentRequest.getDescription());
        return payment;
    }
}
