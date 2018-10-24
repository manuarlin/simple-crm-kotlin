package com.group.crmkotlin.service

import com.group.crmkotlin.model.Product
import com.group.crmkotlin.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(val productRepository: ProductRepository) : IProductService {

    override fun findById(id: String): Optional<Product> {
        return productRepository.findById(id.toLong()).map { Product(it) }
    }

}