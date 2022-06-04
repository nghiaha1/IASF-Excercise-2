package com.spring.iasfex2.controller.product;

import com.spring.iasfex2.entity.Product;
import com.spring.iasfex2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Product>> getAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> create(@RequestBody Product obj) {
        return ResponseEntity.ok(productService.save(obj));
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (optionalProduct.isPresent()) {
            ResponseEntity.ok(optionalProduct.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product updatedObj) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(updatedObj.getName());
            existingProduct.setSlug(updatedObj.getSlug());
            existingProduct.setDescription(updatedObj.getDescription());
            existingProduct.setDetail(updatedObj.getDetail());
            existingProduct.setPrice(updatedObj.getPrice());
            existingProduct.setThumbnail(updatedObj.getThumbnail());
            existingProduct.setManufacturer(updatedObj.getManufacturer());
            productService.save(existingProduct);
            return ResponseEntity.ok(productService.save(existingProduct));
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (optionalProduct.isPresent()) {
            productService.delete(id);
            ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
