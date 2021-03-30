package com.github.yoshiyoshifujii.mspsaga.order.interfaceAdaptor.saga

case class SagaInstance(
    sagaType: String,
    id: String,
    lastRequestId: String,
    serializedSagaData: SerializedSagaData,
    stateName: String,
    destinationsAndResources: DestinationsAndResources,
    endState: Boolean = false,
    compensating: Boolean = false
)
