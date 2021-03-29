package com.github.yoshiyoshifujii.mspsaga.order.usecase

import com.github.yoshiyoshifujii.mspsaga.order.interfaceAdaptor.saga.{CreateOrderSagaState, SagaManager}

class CreateOrderUseCase(
    createOrderSagaManager: SagaManager[CreateOrderSagaState]
) {}
