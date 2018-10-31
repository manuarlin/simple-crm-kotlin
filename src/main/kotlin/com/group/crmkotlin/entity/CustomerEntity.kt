package com.group.crmkotlin.entity

import javax.persistence.*

@Entity
@Table(name = "customer")
data class CustomerEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        val firstName: String?,
        val lastName: String?
) {

    @ManyToMany
    @JoinTable(name = "customer_product", joinColumns = [JoinColumn(name = "customer_id")],
            inverseJoinColumns = [JoinColumn(name = "product_id")])
    val products: List<ProductEntity> = ArrayList()

}