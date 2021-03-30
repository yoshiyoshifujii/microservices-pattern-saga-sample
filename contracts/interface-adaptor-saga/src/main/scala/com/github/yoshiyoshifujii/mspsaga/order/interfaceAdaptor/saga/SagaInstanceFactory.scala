package com.github.yoshiyoshifujii.mspsaga.order.interfaceAdaptor.saga

class SagaInstanceFactory {

  private def makeSagaManager[SagaData](saga: Saga[SagaData]): SagaManager[SagaData] = ???

  def create[SagaData](saga: Saga[SagaData], data: SagaData): SagaInstance = {
    val sagaManager: SagaManager[SagaData] = makeSagaManager(saga)
    sagaManager.create(data)
  }
}
