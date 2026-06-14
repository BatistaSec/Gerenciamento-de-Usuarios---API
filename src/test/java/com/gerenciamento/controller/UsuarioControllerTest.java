package com.gerenciamento.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gerenciamento.JWT.JwtService;
import com.gerenciamento.entity.Usuario;
import com.gerenciamento.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    UsuarioService service;

    @MockitoBean
    JwtService jwtService;

    @Test
    @WithMockUser
    void listar_deveRetornar200()throws Exception{
        Usuario usuario = new Usuario();
        usuario.setNome("joao");
        usuario.setEmail("joao@email.com");
        usuario.setSenha("1234");

        when(service.listarTodos()).thenReturn(List.of(usuario));

        mockMvc.perform(get("/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("joao"));
    }

    @Test
    @WithMockUser
    void buscar_deveRetornarUsuarioPorId()throws Exception{
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("joao");
        when(service.buscarPorId(usuario.getId())).thenReturn(usuario);

        mockMvc.perform(get("/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("joao"));
    }

    @Test
    @WithMockUser
    void deletar_deveRetornar200()throws Exception{
        doNothing().when(service).deletar(1L);

        mockMvc.perform(delete("/usuarios/1"))
                .andExpect(status().isOk());

        verify(service).deletar(1L);

    }
    @Test
    @WithMockUser
    void atualizar_deveRetornarUsuarioAtualizado()throws Exception{
        Usuario atualizado = new Usuario();
        atualizado.setId(1L);
        atualizado.setNome("joao Novo");
        atualizado.setEmail("novo@emai.com");
        atualizado.setSenha("1234");

        when(service.atualizar(eq(1L),any())).thenReturn(atualizado);

        mockMvc.perform(put("/usuarios/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(atualizado)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("joao Novo"));
    }

}