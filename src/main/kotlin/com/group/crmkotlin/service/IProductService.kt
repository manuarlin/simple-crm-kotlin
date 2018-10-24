package com.group.crmkotlin.service

import com.group.crmkotlin.model.Product
import java.util.*

interface IProductService {

    fun findById(id: String): Optional<Product>
}