package com.group.crmkotlin.service

import com.group.crmkotlin.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(val customerRepository: CustomerRepository) {

}