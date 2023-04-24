package com.aws.prac.ecs.mapper;

import com.aws.prac.ecs.dto.ProductRequestDTO;
import com.aws.prac.ecs.dto.ProductResponseDTO;
import com.aws.prac.ecs.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product getProductModelFromProductRequestDTO(ProductRequestDTO productRequestDTO);

    ProductResponseDTO getProductRespDTOFromProductModel(Product product);
}
