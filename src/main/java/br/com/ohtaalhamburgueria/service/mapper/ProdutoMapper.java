package br.com.ohtaalhamburgueria.service.mapper;

import br.com.ohtaalhamburgueria.model.Categoria;
import br.com.ohtaalhamburgueria.model.Produto;
import br.com.ohtaalhamburgueria.model.dto.ProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    @Mapping(source = "categoria.idCategoria", target = "categoria.idCategoria")
    ProdutoDTO toProdutoDTO(Produto produto);

    @Mapping(source = "categoria.idCategoria", target = "categoria.idCategoria")
    Produto toProduto(ProdutoDTO produtoDTO);

}