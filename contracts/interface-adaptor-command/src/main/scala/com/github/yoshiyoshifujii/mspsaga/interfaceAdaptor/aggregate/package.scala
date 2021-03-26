package com.github.yoshiyoshifujii.mspsaga.interfaceAdaptor

package object aggregate {

  trait BaseCommand[Id] {
    def aggregateId: Id
    def idAsString: String
  }

  trait UnsupportedId[Id] {
    self: BaseCommand[Id] =>
    override def aggregateId: Id    = throw new UnsupportedOperationException(s"${this.getClass.getName}")
    override def idAsString: String = throw new UnsupportedOperationException(s"${this.getClass.getName}")
  }

  trait BaseIdle[Id] extends BaseCommand[Id] with UnsupportedId[Id]
  trait BaseStop[Id] extends BaseCommand[Id] with UnsupportedId[Id]

}
