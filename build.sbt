lazy val baseName = "microservices-pattern-saga-sample"

lazy val AkkaVersion = "2.6.13"

lazy val baseSettings = Seq(
  version := "0.1",
  scalaVersion := "2.13.5",
  organization := "com.github.yoshiyoshifujii.mspsaga",
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor-typed"         % AkkaVersion,
    "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test
  )
)

lazy val `contract-interface-adaptor-command` = project
  .in(file("./contracts/interface-adaptor-command"))
  .settings(baseSettings)
  .settings(
    name := s"$baseName-contract-interface-adaptor-command"
  )

lazy val orderService = project
  .in(file("./modules/order-service"))
  .settings(baseSettings)
  .settings(
    name := s"$baseName-order-service"
  )
  .dependsOn(`contract-interface-adaptor-command`)

lazy val consumerService = project
  .in(file("./modules/consumer-service"))
  .settings(baseSettings)
  .settings(
    name := s"$baseName-consumer-service"
  )
  .dependsOn(`contract-interface-adaptor-command`)

lazy val kitchenService = project
  .in(file("./modules/kitchen-service"))
  .settings(baseSettings)
  .settings(
    name := s"$baseName-kitchen-service"
  )
  .dependsOn(`contract-interface-adaptor-command`)

lazy val accountingService = project
  .in(file("./modules/accounting-service"))
  .settings(baseSettings)
  .settings(
    name := s"$baseName-accounting-service"
  )
  .dependsOn(`contract-interface-adaptor-command`)

lazy val root = project
  .in(file("."))
  .settings(baseSettings)
  .settings(
    name := s"$baseName-root"
  )
  .aggregate(
    `contract-interface-adaptor-command`,
    orderService,
    consumerService,
    kitchenService,
    accountingService
  )
