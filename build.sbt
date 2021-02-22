name := "subscriber-api"

version := "0.1"

scalaVersion := "2.13.4"

val AkkaVersion = "2.6.8"
val AkkaHttpVersion = "10.2.3"
val swaggerVersion = "2.1.7"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion,

  "com.github.swagger-akka-http" %% "swagger-akka-http" % "2.4.0",
  "com.github.swagger-akka-http" %% "swagger-scala-module" % "2.3.0",
  "com.github.swagger-akka-http" %% "swagger-enumeratum-module" % "2.1.0",
  "javax.ws.rs" % "javax.ws.rs-api" % "2.0.1",

  "io.swagger.core.v3" % "swagger-core" % swaggerVersion,
  "io.swagger.core.v3" % "swagger-annotations" % swaggerVersion,
  "io.swagger.core.v3" % "swagger-models" % swaggerVersion,
  "io.swagger.core.v3" % "swagger-jaxrs2" % swaggerVersion,

  "co.pragmati" %% "swagger-ui-akka-http" % "1.3.0" // https://github.com/pragmatico/swagger-ui-akka-http
)

// https://github.com/pjfanning/swagger-akka-http-sample
