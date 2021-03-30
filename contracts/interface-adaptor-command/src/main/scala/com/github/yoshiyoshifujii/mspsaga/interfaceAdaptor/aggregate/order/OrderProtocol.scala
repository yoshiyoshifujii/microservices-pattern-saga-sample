package com.github.yoshiyoshifujii.mspsaga.interfaceAdaptor.aggregate.order

import com.github.yoshiyoshifujii.mspsaga.interfaceAdaptor.aggregate.{ BaseCommand, BaseIdle, BaseStop }
import com.github.yoshiyoshifujii.mspsaga.order.domain.model.{
  ConsumerId,
  DeliveryInformation,
  LineItems,
  OrderId,
  RestaurantId
}

object OrderProtocol {

  sealed trait Command extends BaseCommand[OrderId] {
    override def idAsString: String = aggregateId.value
  }
  sealed trait Reply

  case object Idle extends BaseIdle[OrderId] with Command
  case object Stop extends BaseStop[OrderId] with Command

  final case class CommandCreateOrder(
      aggregateId: OrderId,
      consumerId: ConsumerId,
      restaurantId: RestaurantId,
      deliveryInformation: DeliveryInformation,
      lineItems: LineItems
  )                                                            extends Command
  sealed trait ReplyCreateOrder                                extends Reply
  final case class ReplyCreateOrderSucceeded(orderId: OrderId) extends ReplyCreateOrder
  final case class ReplyCreateOrderFailed()                    extends ReplyCreateOrder
}
