package br.com.ambev.order_api.infraestructure.mapper;

import br.com.ambev.order_api.core.domain.ItemOrder;
import br.com.ambev.order_api.infraestructure.entity.ItemOrderEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemOrderMapper {

    ItemOrderEntity modelToEntity(ItemOrder item);
    @InheritInverseConfiguration
    ItemOrder entityToModel(ItemOrderEntity item);

}
