package br.com.ohtaalhamburgueria.service.mapper;

import br.com.ohtaalhamburgueria.model.Usuario;
import br.com.ohtaalhamburgueria.model.dto.UsuarioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toUsuario(UsuarioDTO usuarioDTO);
}
