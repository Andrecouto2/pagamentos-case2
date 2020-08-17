package br.com.mastertech.couto.pagamentos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE, reason = "Serviço de cartões indisponível")
public class CardUnavailableServiceException extends RuntimeException {
}
