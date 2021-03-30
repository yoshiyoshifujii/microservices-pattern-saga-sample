package com.github.yoshiyoshifujii.mspsaga.order.interfaceAdaptor.saga

trait SagaManager[Data] {
  def create(sagaData: Data): SagaInstance
}
