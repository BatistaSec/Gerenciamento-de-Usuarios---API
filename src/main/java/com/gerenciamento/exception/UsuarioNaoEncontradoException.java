package com.gerenciamento.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException (Long id){
        super("Usuario nao encontrado com id: "+id);
    }
}
