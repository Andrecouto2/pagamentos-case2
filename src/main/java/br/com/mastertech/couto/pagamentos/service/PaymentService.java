package br.com.mastertech.couto.pagamentos.service;

import br.com.mastertech.couto.pagamentos.client.Card;
import br.com.mastertech.couto.pagamentos.client.CardClient;
import br.com.mastertech.couto.pagamentos.exception.CardNotActiveException;
import br.com.mastertech.couto.pagamentos.model.Payment;
import br.com.mastertech.couto.pagamentos.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private CardClient cardClient;

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(Payment paymentCreated) {

        Card card = cardClient.getById(paymentCreated.getCardId());
        if (!card.getActive()) {
            throw new CardNotActiveException();
        }

        return paymentRepository.save(paymentCreated);
    }

    public List<Payment> getByCardId(Long cardId) {
        return paymentRepository.findByCardId(cardId);
    }

}
