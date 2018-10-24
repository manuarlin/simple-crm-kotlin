package com.group.crmkotlin.model

fun Double.getCurrencyLabel(currency: String = "€"): String = "$this$currency"