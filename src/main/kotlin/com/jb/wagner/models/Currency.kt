package com.jb.wagner.models

data class Currency(val shortName: String, val longName: String) {
    companion object {
        fun fromString(currency: String) : Currency = when(currency.toLowerCase()) {
            "usd" -> USD
            else -> UNKNOWN_CURRENCY
        }
    }
}

val UNKNOWN_CURRENCY = Currency("???", "unknown currency")
val USD = Currency("usd", "United States Dollar")