package com.jb.wagner.models

import com.jb.wagner.models.transfer.Denomination as TransferDenomination

enum class DenominationType {
    PAPER, COIN
}

class Denomination(val price: Price, val type: DenominationType = DenominationType.COIN) {
    companion object {
        fun fromTransferObject(transferDenom: TransferDenomination) : Denomination {
            // TODO : use custom exception for denomination type doesn't exist
            val type = when(transferDenom.type.toLowerCase()) {
                "coin" -> DenominationType.COIN
                "paper" -> DenominationType.PAPER
                else -> throw Exception("denomination type must be either `coin` or `paper`")
            }
            return Denomination(
                    price = Price(transferDenom.amount, Currency.fromString(transferDenom.currency)),
                    type = type)
        }
    }
}