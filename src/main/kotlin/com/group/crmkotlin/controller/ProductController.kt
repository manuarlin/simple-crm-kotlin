package com.group.crmkotlin.controller

import com.group.crmkotlin.service.IProductService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(val productService: IProductService) {

    @RequestMapping("/products/{id}/price")
    fun findProductPriceById(@PathVariable id: String): String {
        val optionalProduct = productService.findById(id)
        return optionalProduct.map { "Le prix est de ${it.getPriceLabel()}" }.orElse("Produit inconnu")
    }

}