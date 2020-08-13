package br.com.mastertech.couto.pagamentos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CARD")
public interface CardClient {

    @GetMapping("cartao/completecard/{id}")
    Card getById(@PathVariable Long id);
}