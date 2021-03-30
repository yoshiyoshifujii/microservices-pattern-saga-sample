package com.github.yoshiyoshifujii.mspsaga.order.usecase

import akka.NotUsed
import akka.stream.scaladsl.Flow
import com.github.yoshiyoshifujii.mspsaga.order.domain.model._
import com.github.yoshiyoshifujii.mspsaga.order.interfaceAdaptor.saga.{ CreateOrderSagaState, SagaManager }

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
    createOrderSagaManager: SagaManager[CreateOrderSagaState]
) {

  def createOrder: Flow[CreateOrder, CreateOrderResult, NotUsed] =
    Flow[CreateOrder].mapAsync(1) { createOrder =>
      val orderId = OrderId("newId")
      val createOrderSagaState = CreateOrderSagaState(orderId)
      ???
    }

}
