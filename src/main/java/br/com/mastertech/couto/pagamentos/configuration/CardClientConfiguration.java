package br.com.mastertech.couto.pagamentos.configuration;

import br.com.mastertech.couto.pagamentos.client.CardClientFallback;
import br.com.mastertech.couto.pagamentos.decoder.CardClientDecoder;
import feign.Feign;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class CardClientConfiguration {

    @Bean
    public ErrorDecoder getCarClientDecoder() {
        return new CardClientDecoder();
    }

    @Bean
    public Feign.Builder builder() {
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallback(new CardClientFallback(), RetryableException.class)
                .build();

        return Resilience4jFeign.builder(decorators);
    }

}
