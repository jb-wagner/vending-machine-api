package com.jb.wagner.models.transfer

data class Denomination(val amount: Long = 0, val currency: String = "usd", val type: String = "coin")