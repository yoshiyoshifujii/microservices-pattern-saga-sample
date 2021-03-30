package com.github.yoshiyoshifujii.mspsaga.order.usecase

import com.github.yoshiyoshifujii.mspsaga.interfaceAdaptor.aggregate.order.OrderProtocol
import com.github.yoshiyoshifujii.mspsaga.order.domain.model.OrderId

case class CreateOrderSagaState(
    orderId: OrderId,
    commandCreateOrder: OrderProtocol.CommandCreateOrder
)
