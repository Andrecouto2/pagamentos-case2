package br.com.mastertech.couto.pagamentos.configuration;

import br.com.mastertech.couto.pagamentos.decoder.CardClientDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CardClientConfiguration {

    @Bean
    public ErrorDecoder getCarClientDecoder() {
        return new CardClientDecoder();
    }

}
