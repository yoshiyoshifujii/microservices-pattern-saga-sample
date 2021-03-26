package com.github.yoshiyoshifujii.mspsaga.order.usecase

import com.github.yoshiyoshifujii.mspsaga.order.domain.model.OrderId

case class CreateOrderSagaState(
    orderId: OrderId
)
