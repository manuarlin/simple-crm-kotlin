package com.group.crmkotlin.model

import com.group.crmkotlin.entity.CustomerEntity
import kotlin.streams.toList

data class Customer(val id: Long,
                    val firstName: String?,
                    val lastName: String?,
                    val products: List<Product>) {

    constructor(customerEntity: CustomerEntity) : this(customerEntity.id,
            customerEntity.firstName,
            customerEntity.lastName,
            ArrayList()
    ) {
        mapListOfProduct(customerEntity)
    }

    private fun mapListOfProduct(customerEntity: CustomerEntity) =
            customerEntity.products.stream().map { Product(it) }.toList()

}