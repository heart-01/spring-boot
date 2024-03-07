package org.example.productservice.controllers

import org.example.productservice.models.Product
import org.example.productservice.services.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/products")
class ProductController(private val productService: ProductService) {
    // GET /api/v1/products
    @GetMapping
    fun getAllProducts(): List<Product> = productService.getAllProducts()

    // GET /api/v1/products/{id}
    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Int): ResponseEntity<Product> {
        val product = productService.getProductById(id)
        return product.map { ResponseEntity.ok(it) }
            .orElseGet { ResponseEntity(HttpStatus.NOT_FOUND) }
    }

    // POST /api/v1/products
    @PostMapping
    fun createProduct(@RequestBody product: Product): ResponseEntity<Product> {
        val createdProduct = productService.createProduct(product)
        return ResponseEntity(createdProduct, HttpStatus.CREATED)
    }

    // PUT /api/v1/products/{id}
    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Int, @RequestBody updateProduct: Product): ResponseEntity<Product> {
        val updatedProduct = productService.updateProduct(id, updateProduct)
        return ResponseEntity(updatedProduct, HttpStatus.OK)
    }

    // DELETE /api/v1/products/{id}
    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Int): ResponseEntity<Void> {
        productService.deleteProduct(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

}