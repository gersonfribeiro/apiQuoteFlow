package com.workspacepi.apiquoteflow.adapters.http.error;

import com.workspacepi.apiquoteflow.application.cotacao.exceptions.CotacaoNaoEncontradaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@ControllerAdvice
public class ErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);

    // Método para lidar com CotacaoNaoEncontradaException

    @ExceptionHandler(CotacaoNaoEncontradaException.class)
    public ResponseEntity<ErrorResponse> handleCotacaoNaoEncontradaException(CotacaoNaoEncontradaException e) {
        return buildResponse(e.getCotacaoId(), HttpStatus.NOT_FOUND, "Cotação não encontrada", e);
    }

    // Método genérico para outras exceções

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        return buildResponse(null, HttpStatus.BAD_REQUEST, "Erro desconhecido", e);
    }

    // Método auxiliar para construir a resposta

    private ResponseEntity<ErrorResponse> buildResponse(UUID id, HttpStatus status, String message, Throwable throwable) {
        ErrorResponse response = new ErrorResponse(id, message);
        String fullMessage = "[" + status.value() + "] [" + throwable.getClass().getSimpleName() + "] " + message;

        if (status.is5xxServerError()) {
            LOGGER.error(fullMessage, throwable);
        } else {
            LOGGER.warn(fullMessage);
        }

        return ResponseEntity.status(status).body(response);
    }
}
