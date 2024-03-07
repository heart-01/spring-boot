package org.example.productservice.services

import org.example.productservice.models.Product
import org.example.productservice.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(private val productRepository: ProductRepository) {
    // Get all products
    fun getAllProducts(): List<Product> = productRepository.findAll()

    // Get product by id
    fun getProductById(id: Int): Optional<Product> = productRepository.findById(id)

    // Create a new product
    fun createProduct(product: Product): Product = productRepository.save(product)

    // Update a product
    fun updateProduct(id: Int, product: Product): Product {
        val existingProduct = productRepository.existsById(id)
        if (existingProduct) {
            product.id = id
            productRepository.save(product)
        } else {
            throw RuntimeException("Product not found with id: $id")
        }
        return product
    }

    // Delete a product
    fun deleteProduct(id: Int) {
        val existingProduct = productRepository.existsById(id)
        if (existingProduct) {
            productRepository.deleteById(id)
        } else {
            throw RuntimeException("Product not found with id: $id")
        }
    }
}