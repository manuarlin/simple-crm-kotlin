package com.group.crmkotlin.model

class Price : Comparable<Price> {

    var amount: Double?
        set(value) {
            if (value != null && value >= 0) {
                field = value
            }
        }

    constructor(_amount: Double) {
        amount = _amount
    }

    override fun toString(): String {
        return amount!!.toString()
    }

    operator fun plus(price: Price): Price {
        return Price(amount!! + price.amount!!)
    }

    override fun compareTo(other: Price): Int {
        return (amount!! - other.amount!!).toInt()
    }
}