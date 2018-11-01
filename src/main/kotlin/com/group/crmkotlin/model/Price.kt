package com.group.crmkotlin.model

class Price {

    var amount: Double?
        get() {
            return field
        }
        set(value) {
            field = value
        }

    constructor(_amount: Double) {
        amount = _amount
    }
}