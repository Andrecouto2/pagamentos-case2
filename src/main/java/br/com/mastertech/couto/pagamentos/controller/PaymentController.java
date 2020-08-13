package br.com.mastertech.couto.pagamentos.controller;

import br.com.mastertech.couto.pagamentos.model.Payment;
import br.com.mastertech.couto.pagamentos.model.dtos.CreatePaymentRequest;
import br.com.mastertech.couto.pagamentos.model.dtos.CreatePaymentResponse;
import br.com.mastertech.couto.pagamentos.model.dtos.GetPaymentResponse;
import br.com.mastertech.couto.pagamentos.model.dtos.PaymentMapper;
import br.com.mastertech.couto.pagamentos.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PaymentController {

    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/pagamento", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreatePaymentResponse> createPayment(@RequestBody CreatePaymentRequest paymentRequest) {
        Payment newPayment = paymentService.createPayment(paymentMapper.toPayment(paymentRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentMapper.toCreatePaymentResponse(newPayment));
    }

    @GetMapping(value = "/pagamentos/{id_cartao}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GetPaymentResponse>> getPaymentsByCardId(@PathVariable("id_cartao") Long cardId) {
        List<GetPaymentResponse> pagamentoModels = paymentService.getByCardId(cardId).stream()
                .map(paymentMapper::toGetPaymentResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pagamentoModels);
    }
}
