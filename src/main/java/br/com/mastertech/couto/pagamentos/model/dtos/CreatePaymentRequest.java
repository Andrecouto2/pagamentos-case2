package br.com.mastertech.couto.pagamentos.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class CreatePaymentRequest {

    @Getter
    @Setter
    @JsonProperty(value = "cartao_id")
    private Long cardId;

    @Getter
    @Setter
    @JsonProperty(value = "descricao")
    private String description;

    @Getter
    @Setter
    @JsonProperty(value = "valor")
    private Double value;
}
