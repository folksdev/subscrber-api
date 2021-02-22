package com.folksdev.subsciber.api

import akka.actor.typed.ActorSystem

import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._

trait Paths {

  implicit def actorSystem: ActorSystem[Any]

  val route =
    path("hello") {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))
      }
    }

}
