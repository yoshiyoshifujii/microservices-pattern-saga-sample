lazy val baseName = "microservices-pattern-saga-sample"

lazy val AkkaVersion = "2.6.13"

lazy val baseSettings = Seq(
  version := "0.1",
  scalaVersion := "2.13.5",
  organization := "com.github.yoshiyoshifujii",
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor-typed"         % AkkaVersion,
    "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test
  )
)

lazy val orderService = project
  .in(file("./modules/order-service"))
  .settings(baseSettings)
  .settings(
    name := s"$baseName-order-service"
  )

lazy val consumerService = project
  .in(file("./modules/consumer-service"))
  .settings(baseSettings)
  .settings(
    name := s"$baseName-consumer-service"
  )

lazy val kitchenService = project
  .in(file("./modules/kitchen-service"))
  .settings(baseSettings)
  .settings(
    name := s"$baseName-kitchen-service"
  )

lazy val accountingService = project
  .in(file("./modules/accounting-service"))
  .settings(baseSettings)
  .settings(
    name := s"$baseName-accounting-service"
  )

lazy val root = project
  .in(file("."))
  .settings(baseSettings)
  .settings(
    name := s"$baseName-root"
  )
  .aggregate(
    orderService,
    consumerService,
    kitchenService,
    accountingService
  )
