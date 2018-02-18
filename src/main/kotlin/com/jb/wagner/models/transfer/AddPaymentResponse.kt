package com.jb.wagner.models.transfer

data class AddPaymentResponse(
    override var status: Int = 200,
    override var message: String? = null,
    val total: com.jb.wagner.models.Price
) : Response()