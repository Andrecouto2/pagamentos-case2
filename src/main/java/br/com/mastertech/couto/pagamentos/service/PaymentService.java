package br.com.mastertech.couto.pagamentos.service;

import br.com.mastertech.couto.pagamentos.client.Card;
import br.com.mastertech.couto.pagamentos.client.CardClient;
import br.com.mastertech.couto.pagamentos.exception.CardNotActiveException;
import br.com.mastertech.couto.pagamentos.exception.CardNotFoundException;
import br.com.mastertech.couto.pagamentos.model.Payment;
import br.com.mastertech.couto.pagamentos.model.dtos.CreatePaymentRequest;
import br.com.mastertech.couto.pagamentos.model.dtos.GetPaymentResponse;
import br.com.mastertech.couto.pagamentos.model.dtos.PaymentMapper;
import br.com.mastertech.couto.pagamentos.repository.PaymentRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private CardClient cardClient;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    public Payment createPayment(Payment paymentCreated) {
        try {
            Card card = cardClient.getById(paymentCreated.getCardId());
            if (!card.getActive()) {
                throw new CardNotActiveException();
            }
        } catch (FeignException.FeignClientException.NotFound ex) {
            throw new CardNotFoundException();
        }

        return paymentRepository.save(paymentCreated);
    }

    public List<Payment> getByCardId(Long cardId) {
        return paymentRepository.findByCardId(cardId);
    }

}
