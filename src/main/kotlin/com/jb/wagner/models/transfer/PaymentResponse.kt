package com.jb.wagner.models.transfer

import com.jb.wagner.models.Denomination
import com.jb.wagner.models.Price

data class PaymentResponse(override var status: Int,
                           override var message: String? = null,
                           val payments: List<Denomination>,
                           val total: Price) : Response()