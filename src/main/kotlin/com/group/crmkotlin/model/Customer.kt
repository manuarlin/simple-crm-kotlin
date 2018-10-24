package com.group.crmkotlin.model

import com.group.crmkotlin.entity.CustomerEntity
import kotlin.streams.toList

class Customer(val id: Long,
                    val firstName: String?,
                    val lastName: String?,
                    val products: List<Product>) {

}