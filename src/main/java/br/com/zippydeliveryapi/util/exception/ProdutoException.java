package br.com.zippydeliveryapi.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ProdutoException extends RuntimeException {

    public static final String MSG_DISPONIBILIDADE_PRODUTO = "Não é permitido inserir produtos que não estejam disponíveis";

    public ProdutoException(String msg) {

	super(String.format(msg));
    }
}
