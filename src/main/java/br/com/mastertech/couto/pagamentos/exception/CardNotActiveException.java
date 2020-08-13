package br.com.mastertech.couto.pagamentos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.PRECONDITION_REQUIRED, reason = "Cartão inativo")
public class CardNotActiveException extends RuntimeException {
}
