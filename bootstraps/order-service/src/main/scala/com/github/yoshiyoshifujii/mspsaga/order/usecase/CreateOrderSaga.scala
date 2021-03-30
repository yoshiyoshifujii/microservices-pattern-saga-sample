package com.github.yoshiyoshifujii.mspsaga.order.usecase

import com.github.yoshiyoshifujii.mspsaga.order.interfaceAdaptor.saga.Saga

class CreateOrderSaga(sagaDefinition: SagaDefinition[CreateOrderSagaState]) extends Saga[CreateOrderSagaState] {}
