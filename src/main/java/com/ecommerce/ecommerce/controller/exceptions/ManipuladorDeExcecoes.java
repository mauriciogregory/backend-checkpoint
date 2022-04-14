package com.ecommerce.ecommerce.controller.exceptions;

import com.ecommerce.ecommerce.service.Exception.BDexcecao;
import com.ecommerce.ecommerce.service.Exception.EntidadeNaoEncontrada;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ManipuladorDeExcecoes {

    @ExceptionHandler(EntidadeNaoEncontrada.class)
    public ResponseEntity<ErroPadrao> entidadeNaoEncontrada(
            EntidadeNaoEncontrada e, HttpServletRequest request){
        ErroPadrao ep = new ErroPadrao();
        ep.setTimestamp(Instant.now());
        ep.setStatus(HttpStatus.NOT_FOUND.value());
        ep.setError("Recurso não encontrado!");
        ep.setMessage(e.getMessage());
        ep.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ep);
    }

    @ExceptionHandler(BDexcecao.class)
    public ResponseEntity<ErroPadrao> dataBase(BDexcecao bdExcep, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroPadrao ep = new ErroPadrao();
        ep.setTimestamp(Instant.now());
        ep.setStatus(status.value());
        ep.setError("Exceção no Banco De Dados! - Integridade");
        ep.setMessage(bdExcep.getMessage());
        ep.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(ep);
    }
}
