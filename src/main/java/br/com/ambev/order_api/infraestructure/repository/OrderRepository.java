package br.com.ambev.order_api.infraestructure.repository;

import br.com.ambev.order_api.core.enums.StatusOrder;
import br.com.ambev.order_api.infraestructure.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends ListCrudRepository<OrderEntity, Long> {
    OrderEntity findByNrOrder(String nrOrder);
    List<OrderEntity> findByStatus(StatusOrder status);
}
