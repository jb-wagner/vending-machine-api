package com.jb.wagner.models

data class Product(val sku: String,
                   val model: String,
                   val name: String,
                   val description: String,
                   val price: Price)