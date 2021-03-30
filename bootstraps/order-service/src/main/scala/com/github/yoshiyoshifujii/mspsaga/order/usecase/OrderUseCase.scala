package com.github.yoshiyoshifujii.mspsaga.order.usecase

import akka.NotUsed
import akka.stream.scaladsl.Flow
import com.github.yoshiyoshifujii.mspsaga.interfaceAdaptor.aggregate.order.OrderProtocol
import com.github.yoshiyoshifujii.mspsaga.order.domain.model._
import com.github.yoshiyoshifujii.mspsaga.order.interfaceAdaptor.saga.SagaInstanceFactory

final case class CreateOrder(
    consumerId: ConsumerId,
    restaurantId: RestaurantId,
    deliveryInformation: DeliveryInformation,
    lineItems: LineItems
)
sealed trait CreateOrderResult
final case class CreateOrderResultSucceeded(orderId: OrderId) extends CreateOrderResult
final case class CreateOrderResultFailed()                    extends CreateOrderResult

class OrderUseCase(
    sagaInstanceFactory: SagaInstanceFactory,
    createOrderSaga: CreateOrderSaga
) {

  def createOrder: Flow[CreateOrder, CreateOrderResult, NotUsed] =
    Flow[CreateOrder].mapAsync(1) { createOrder =>
      val orderId = OrderId("newId")
      val command = OrderProtocol.CommandCreateOrder(
        orderId,
        createOrder.consumerId,
        createOrder.restaurantId,
        createOrder.deliveryInformation,
        createOrder.lineItems
      )
      val sagaData     = CreateOrderSagaState(orderId, command)
      val sagaInstance = sagaInstanceFactory.create(createOrderSaga, sagaData)
      ???
    }

}
