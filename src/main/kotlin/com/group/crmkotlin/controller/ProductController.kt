package com.group.crmkotlin.controller

import com.group.crmkotlin.service.IProductService
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(val productService: IProductService) {

}