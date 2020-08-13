package br.com.mastertech.couto.pagamentos.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class Card {

    @Getter
    @Setter
    public Long id;

    @Getter
    @Setter
    @JsonProperty("numero")
    private String number;

    @Getter
    @Setter
    @JsonProperty("clienteId")
    private Long customerId;

    @Getter
    @Setter
    @JsonProperty("ativo")
    private Boolean active;
}
