package com.group.crmkotlin.entity

import javax.persistence.*

class ProductEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        val description: String?,
        val price: Double?
)
