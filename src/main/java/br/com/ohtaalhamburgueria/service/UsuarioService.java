package br.com.ohtaalhamburgueria.service;

import br.com.ohtaalhamburgueria.model.Usuario;
import br.com.ohtaalhamburgueria.model.dto.UsuarioDTO;
import br.com.ohtaalhamburgueria.repository.UsuarioRepository;
import br.com.ohtaalhamburgueria.service.mapper.UsuarioMapper;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;


    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario createUsuario(UsuarioDTO usuarioDTO) {
        var existeUsuario = usuarioRepository.findByEmail(usuarioDTO.email());
        if (existeUsuario.isPresent()) {
            throw new EntityExistsException("Usuário ja cadastrado");
        }
        Usuario usuario = usuarioMapper.toUsuario(usuarioDTO);

        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}