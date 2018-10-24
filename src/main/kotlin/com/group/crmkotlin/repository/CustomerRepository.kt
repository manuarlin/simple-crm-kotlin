package com.group.crmkotlin.repository

import com.group.crmkotlin.entity.CustomerEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface CustomerRepository : CrudRepository<CustomerEntity, Long> {

    override fun findAll(): List<CustomerEntity>
    fun findByLastNameIgnoreCase(lastName: String): List<CustomerEntity>
    fun findByLastNameIgnoreCaseAndFirstNameIgnoreCase(lastName: String, firstName: String): List<CustomerEntity>
    override fun findById(id: Long): Optional<CustomerEntity>
}