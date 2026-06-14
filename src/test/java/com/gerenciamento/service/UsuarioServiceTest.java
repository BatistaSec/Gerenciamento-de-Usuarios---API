package com.gerenciamento.service;

import com.gerenciamento.entity.Usuario;
import com.gerenciamento.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    UsuarioRepository repository;
    @InjectMocks
    UsuarioService service;

    @Test
    void buscarPorId(){
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(()->service.buscarPorId(99L))
        .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Usuario nao encontrado");
    }

    @Test
    void listarTodos_deveRetornarLista(){
        Usuario usuario = new Usuario();
        usuario.setNome("Ana");
        when(repository.findAll()).thenReturn(List.of(usuario));
        List<Usuario> resultado = service.listarTodos();
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getNome()).isEqualTo("Ana");
    }
    @Test
    void criar_deveSalvarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNome("Carlos");
        when(repository.save(any())).thenReturn(usuario);

        Usuario resultado = service.criar(usuario);

        assertThat(resultado.getNome()).isEqualTo("Carlos");
        verify(repository).save(usuario);
    }

    @Test
    void deletar_deveChamarDeleteById(){
        doNothing().when(repository).deleteById(1L);

        service.deletar(1L);
        verify(repository).deleteById(1L);
    }
    @Test
    void atualizar_deveAtualizarUsuario(){
        Usuario existente = new Usuario();
        existente.setId(1L);
        existente.setNome("Velho");
        existente.setEmail("velho@email.com");
        existente.setSenha("1234");

        Usuario novo = new Usuario();
        novo.setNome("novo");
        novo.setEmail("novo@email.com");
        novo.setSenha("1234");

        when(repository.findById(1L)).thenReturn(Optional.of(existente));
        when(repository.save(any())).thenAnswer(i->i.getArgument(0));

        Usuario resultado = service.atualizar(1L, novo);

        assertThat(resultado.getNome()).isEqualTo("novo");

    }

}