package com.gerenciamento.service;

import com.gerenciamento.entity.Usuario;
import com.gerenciamento.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository  repository;

    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }

    public List<Usuario> listarTodos(){
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
    }

    public Usuario criar(Usuario usuario){
        return repository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuario){
        Usuario existente = buscarPorId(id);
        existente.setNome(usuario.getNome());
        existente.setEmail(usuario.getEmail());
        existente.setSenha(usuario.getSenha());
        return repository.save(existente);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

}
