package com.aws.prac.ecs.services;

import com.aws.prac.ecs.dto.ProductRequestDTO;
import com.aws.prac.ecs.dto.ProductResponseDTO;
import com.aws.prac.ecs.mapper.ProductMapper;
import com.aws.prac.ecs.model.Product;
import com.aws.prac.ecs.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO getProductById(Long productId) {
        Optional<Product> optionalProduct =  productRepository.findById(productId);
        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            return ProductMapper.INSTANCE.getProductRespDTOFromProductModel(product);
        }
        return null;
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(ProductMapper.INSTANCE::getProductRespDTOFromProductModel)
                .collect(Collectors.toList());
    }

    public ProductResponseDTO registerNewProduct(ProductRequestDTO productRequestDTO) {
        Product product = ProductMapper.INSTANCE.getProductModelFromProductRequestDTO(productRequestDTO);
        product.setProductInsertionTS(LocalDate.now());
        return ProductMapper.INSTANCE.getProductRespDTOFromProductModel(productRepository.saveAndFlush(product));
    }
}
