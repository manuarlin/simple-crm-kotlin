package com.group.crmkotlin.service

import com.group.crmkotlin.model.Customer
import com.group.crmkotlin.repository.CustomerRepository
import org.springframework.stereotype.Service
import java.util.*
import kotlin.streams.toList

@Service
class CustomerService(val customerRepository: CustomerRepository) : ICustomerService {

    override fun findAll(): List<Customer> {
        return customerRepository.findAll().stream().map { Customer(it) }.toList()
    }

    override fun findByLastNameIgnoreCase(lastName: String): List<Customer> {
        return customerRepository.findByLastNameIgnoreCase(lastName).stream().map { Customer(it) }.toList()
    }

    override fun findByLastNameAndFirstName(lastName: String, firstName: String): List<Customer> {
        return customerRepository.findByLastNameIgnoreCaseAndFirstNameIgnoreCase(lastName, firstName).stream().map { Customer(it) }.toList()
    }

    override fun findById(id: String): Optional<Customer> {
        return customerRepository.findById(id.toLong()).map { Customer(it) }
    }
}