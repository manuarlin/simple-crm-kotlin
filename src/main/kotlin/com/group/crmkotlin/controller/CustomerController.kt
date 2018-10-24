package com.group.crmkotlin.controller

import com.group.crmkotlin.model.Customer
import com.group.crmkotlin.model.Price
import com.group.crmkotlin.model.Product
import com.group.crmkotlin.service.ICustomerService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.streams.toList

@RestController
class CustomerController(val customerService: ICustomerService) {

    @RequestMapping("/customers/{name}")
    fun findCustomerByLastName(@PathVariable name: String): List<Customer> {
        return customerService.findByLastNameIgnoreCase(name)
    }

    @RequestMapping("/customers/{lastName}/{firstName}")
    fun findCustomerByLastNameAndFirstName(@PathVariable lastName: String, @PathVariable firstName: String): List<Customer> {
        return customerService.findByLastNameAndFirstName(lastName = lastName, firstName = firstName)
    }

    @RequestMapping("/customers/{id}/description")
    fun getCustomerDescription(@PathVariable id: String): String {
        var description = "Inconnu"
        val optionalCustomer = customerService.findById(id)
        if (optionalCustomer.isPresent) {
            val (_, firstName, lastName) = optionalCustomer.get()
            description = "$firstName $lastName"
        }
        return description
    }

    @RequestMapping("/customers/{id}/products")
    fun findProductsByCustomer(@PathVariable id: String): List<Product> {
        var products: List<Product> = ArrayList()
        val optionalCustomer = customerService.findById(id)
        if (optionalCustomer.isPresent) {
            products = optionalCustomer.get().products
        }
        return products
    }

    @RequestMapping("/customers/{id}/total")
    fun findTotalByCustomer(@PathVariable id: String): Price {
        val products = findProductsByCustomer(id)
        var totalPrice = Price(0.0)
        for (product in products) {
            totalPrice += product.price!!
        }
        return totalPrice
    }

    @RequestMapping("/customers/totals")
    fun getTop(): List<Price> {
        val customers = customerService.findAll()
        val totals = customers.stream().map { customer -> findTotalByCustomer(customer.id.toString()) }.toList()
        return totals.reversed()

    }

}