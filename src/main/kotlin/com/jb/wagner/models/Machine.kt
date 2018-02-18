package com.jb.wagner.models

class Machine(val inventory: List<StockItem>) {

    private val mPayment = mutableListOf<Denomination>()

    val payment: List<Denomination>
        get() = mPayment

    fun paymentTotal() : Price = Price(mPayment
            .map(Denomination::price)
            .map(Price::amount).sum(), USD)

    fun addPayment(denomination: Denomination) = mPayment.add(denomination)

    fun refundPayment() : List<Denomination> {
        val allDenominations = mutableListOf<Denomination>().apply { addAll(mPayment) }
        mPayment.clear()
        return allDenominations
    }
}