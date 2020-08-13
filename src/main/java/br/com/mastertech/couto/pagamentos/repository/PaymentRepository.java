package br.com.mastertech.couto.pagamentos.repository;

import br.com.mastertech.couto.pagamentos.model.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
    List<Payment> findByCardId(Long cartaoId);
}
