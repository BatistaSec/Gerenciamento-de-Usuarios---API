package com.gerenciamento.controller;

import com.gerenciamento.JWT.JwtService;
import com.gerenciamento.entity.Usuario;
import com.gerenciamento.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@SecurityRequirement(name="Bearer Authentication")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;
    private final JwtService jwtService;

    public UsuarioController(UsuarioService service, JwtService jwtService){
        this.service = service;
        this.jwtService = jwtService;
    }

    @GetMapping
    public List<Usuario> listar(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @Operation(summary = "Realiza login e gera JWT")
    @PostMapping
    public Map<String,String> criarUsuario(@RequestBody Usuario usuario){

        String token =
                jwtService.generateToken(usuario.getEmail());
        return Map.of("token",token);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario){
        return service.atualizar(id,usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id){
        service.deletar(id);
    }
}
