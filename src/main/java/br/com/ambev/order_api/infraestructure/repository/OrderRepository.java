package br.com.ambev.order_api.infraestructure.repository;

import br.com.ambev.order_api.infraestructure.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends ListCrudRepository<OrderEntity, Long> {
    OrderEntity findByNrOrder(String nrOrder);
}
