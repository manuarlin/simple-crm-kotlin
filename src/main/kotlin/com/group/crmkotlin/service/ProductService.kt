package com.group.crmkotlin.service

import com.group.crmkotlin.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(val productRepository: ProductRepository) {

}