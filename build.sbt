lazy val baseName = "microservices-pattern-saga-sample"

lazy val AkkaVersion = "2.6.14"

lazy val baseSettings = Seq(
  version := "0.1",
  scalaVersion := "2.13.6",
  organization := "com.github.yoshiyoshifujii.mspsaga"
)

lazy val bootstrapsSettings = Seq(
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor-typed"         % AkkaVersion,
    "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test,
    "com.typesafe.akka" %% "akka-stream"              % AkkaVersion,
    "com.typesafe.akka" %% "akka-stream-testkit"      % AkkaVersion % Test
  )
)

lazy val domain = project
  .in(file("./modules/domain"))
  .settings(baseSettings)
  .settings(
    name := s"$baseName-domain"
  )

lazy val `contract-interface-adaptor-command` = project
  .in(file("./contracts/interface-adaptor-command"))
  .settings(baseSettings)
  .settings(
    name := s"$baseName-contract-interface-adaptor-command"
  )
  .dependsOn(domain)

lazy val `contract-interface-adaptor-saga` = project
  .in(file("./contracts/interface-adaptor-saga"))
  .settings(baseSettings)
  .settings(
    name := s"$baseName-contract-interface-adaptor-saga"
  )
  .dependsOn(domain)

lazy val orderService = project
  .in(file("./bootstraps/order-service"))
  .settings(baseSettings, bootstrapsSettings)
  .settings(
    name := s"$baseName-order-service"
  )
  .dependsOn(`contract-interface-adaptor-command`, `contract-interface-adaptor-saga`)

lazy val consumerService = project
  .in(file("./bootstraps/consumer-service"))
  .settings(baseSettings, bootstrapsSettings)
  .settings(
    name := s"$baseName-consumer-service"
  )
  .dependsOn(`contract-interface-adaptor-command`, `contract-interface-adaptor-saga`)

lazy val kitchenService = project
  .in(file("./bootstraps/kitchen-service"))
  .settings(baseSettings, bootstrapsSettings)
  .settings(
    name := s"$baseName-kitchen-service"
  )
  .dependsOn(`contract-interface-adaptor-command`, `contract-interface-adaptor-saga`)

lazy val accountingService = project
  .in(file("./bootstraps/accounting-service"))
  .settings(baseSettings, bootstrapsSettings)
  .settings(
    name := s"$baseName-accounting-service"
  )
  .dependsOn(`contract-interface-adaptor-command`, `contract-interface-adaptor-saga`)

lazy val root = project
  .in(file("."))
  .settings(baseSettings)
  .settings(
    name := s"$baseName-root"
  )
  .aggregate(
    domain,
    `contract-interface-adaptor-command`,
    `contract-interface-adaptor-saga`,
    orderService,
    consumerService,
    kitchenService,
    accountingService
  )
