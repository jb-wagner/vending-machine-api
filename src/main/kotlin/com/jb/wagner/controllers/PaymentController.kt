package com.jb.wagner.controllers

import com.jb.wagner.models.Denomination
import com.jb.wagner.models.Machine
import com.jb.wagner.models.transfer.AddPaymentResponse
import com.jb.wagner.models.transfer.PaymentResponse
import com.jb.wagner.models.transfer.Response
import io.javalin.Context
import com.jb.wagner.models.transfer.Denomination as TransferDenomination

class PaymentController(private val machine: Machine) {
    fun getPayment(ctx: Context) {
        ctx.json(PaymentResponse(
                status = 200,
                payments = machine.payment,
                total = machine.paymentTotal()
            )
        )
    }

    fun addPayment(ctx: Context) {
        val transferDenomination = ctx.bodyAsClass(TransferDenomination::class.java)
        val denomination = Denomination.fromTransferObject(transferDenomination)
        machine.addPayment(denomination)

        ctx.json(
                AddPaymentResponse(200,
                        "Added ${denomination.price.amount} ${denomination.price.currency.shortName}",
                        total = machine.paymentTotal()
                )
        )
    }

    fun refundPayment(ctx: Context) {
        // TODO : Unimplemented
        ctx.json(Response().apply {
            status = 500
            message = "Functionality unimplemented"
        })
    }
}