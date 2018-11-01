package com.group.crmkotlin.model

import com.group.crmkotlin.entity.CustomerEntity

class Customer(val id: Long,
               val firstName: String?,
               val lastName: String?,
               val products: List<Product>) {

    constructor(customerEntity: CustomerEntity) : this(customerEntity.id,
            customerEntity.firstName,
            customerEntity.lastName,
            customerEntity.products.map { Product(it) }
    )

}