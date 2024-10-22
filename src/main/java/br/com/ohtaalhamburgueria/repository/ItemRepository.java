package br.com.ohtaalhamburgueria.repository;

import br.com.ohtaalhamburgueria.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    Item findItemByIdItem(Integer idItem);

}
