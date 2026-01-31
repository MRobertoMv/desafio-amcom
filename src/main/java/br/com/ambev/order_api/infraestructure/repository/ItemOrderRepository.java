package br.com.ambev.order_api.infraestructure.repository;

import br.com.ambev.order_api.infraestructure.entity.ItemOrderEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrderRepository extends ListCrudRepository<ItemOrderEntity, Long> {
}
