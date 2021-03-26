package com.github.yoshiyoshifujii.mspsaga.interfaceAdaptor.aggregate.order

import com.github.yoshiyoshifujii.mspsaga.interfaceAdaptor.aggregate.BaseCommand

object OrderProtocol {

  sealed trait Command extends BaseCommand[OrderId]

}
