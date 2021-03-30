package com.github.yoshiyoshifujii.mspsaga.order.usecase

trait SagaDefinition[Data] {

  def start(sagaData: Data): SagaActions[Data]
  def handleReply(currentState: String, sagaData: Data, message: String): SagaActions[Data]
}
