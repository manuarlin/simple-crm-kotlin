package com.group.crmkotlin.repository

import com.group.crmkotlin.entity.ProductEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface ProductRepository : CrudRepository<ProductEntity, Long> {

    override fun findById(id: Long): Optional<ProductEntity>
}