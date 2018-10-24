package com.group.crmkotlin.controller

import com.group.crmkotlin.service.ICustomerService
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(val customerService: ICustomerService) {

}