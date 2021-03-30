package com.github.yoshiyoshifujii.mspsaga.order.interfaceAdaptor.saga

trait Saga[Data] {

  def onStarting(sagaId: String, data: Data): Unit = {}
  def onSagaCompletedSuccessfully(sagaId: String, data: Data): Unit = {}
  def onSagaRolledBack(sagaId: String, data: Data): Unit = {}
}
