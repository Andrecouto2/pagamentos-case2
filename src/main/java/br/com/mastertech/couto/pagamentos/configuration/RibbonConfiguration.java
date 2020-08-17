package br.com.mastertech.couto.pagamentos.configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

public class RibbonConfiguration {

    @Bean
    public IRule getRule() {
        return new RandomRule();
    }
}
