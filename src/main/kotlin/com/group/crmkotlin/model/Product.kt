package com.group.crmkotlin.model

import com.group.crmkotlin.entity.ProductEntity

data class Product(val id: Long,
                   val description: String?,
                   val price: Price?) {

    constructor(productEntity: ProductEntity) : this(productEntity.id,
            productEntity.description,
            if (productEntity.price != null) Price(productEntity.price) else null)

    fun getPriceLabel(): String {
        return price?.amount?.getCurrencyLabel() ?: "inconnu"
    }

}