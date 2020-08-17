package br.com.mastertech.couto.pagamentos.client;

import br.com.mastertech.couto.pagamentos.exception.CardUnavailableServiceException;

public class CardClientFallback implements CardClient {

    @Override
    public Card getById(Long id) {
        throw new CardUnavailableServiceException();
    }
}
