package com.aws.prac.ecs.controller;

import com.aws.prac.ecs.dto.ProductRequestDTO;
import com.aws.prac.ecs.dto.ProductResponseDTO;
import com.aws.prac.ecs.services.ProductService;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;
    private final ObservationRegistry observationRegistry;

    public ProductController(ProductService productService, ObservationRegistry observationRegistry) {
        this.productService = productService;
        this.observationRegistry = observationRegistry;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable(name = "productId")String productId){
        return Observation.createNotStarted("GET-PRODUCT-BY-ID",observationRegistry)
                .observe(() -> new ResponseEntity<>(productService.getProductById(Long.valueOf(productId)), HttpStatus.OK));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        return Observation.createNotStarted("GET-ALL-PRODUCTS",observationRegistry)
                .observe(() -> new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK));
    }


    @PostMapping("/save")
    public ResponseEntity<ProductResponseDTO> registerNewProduct(@RequestBody ProductRequestDTO productRequestDTO){
        return Observation.createNotStarted("SAVE-NEW-PRODUCT",observationRegistry)
                .observe(() -> new ResponseEntity<>(productService.registerNewProduct(productRequestDTO),HttpStatus.OK));
    }
}
