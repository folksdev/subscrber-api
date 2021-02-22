package com.folksdev.subsciber.api

import com.github.swagger.akka.SwaggerHttpService
import com.github.swagger.akka.model.Info
import io.swagger.v3.oas.models.ExternalDocumentation

// http://localhost:8080/api-docs/swagger.json

class SwaggerPaths extends ApiPath with SwaggerHttpService {

  override val apiClasses = Set(classOf[SubscribersPath])
  override val host = "localhost:8080"
  override val info: Info = Info(version = "1.0")
  override val externalDocs: Option[ExternalDocumentation] = Some(new ExternalDocumentation().description("Core Docs").url("http://acme.com/docs"))
  //override val securitySchemeDefinitions = Map("basicAuth" -> new BasicAuthDefinition())
  override val unwantedDefinitions = Seq("Function1", "Function1RequestContextFutureRouteResult")
}
