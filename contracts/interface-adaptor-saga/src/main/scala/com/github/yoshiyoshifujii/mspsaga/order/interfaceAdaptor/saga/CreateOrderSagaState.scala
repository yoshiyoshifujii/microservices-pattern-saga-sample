package com.github.yoshiyoshifujii.mspsaga.order.interfaceAdaptor.saga

import com.github.yoshiyoshifujii.mspsaga.order.domain.model.OrderId

case class CreateOrderSagaState(
    orderId: OrderId
)
