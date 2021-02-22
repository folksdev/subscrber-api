package com.folksdev.subsciber.api

import akka.actor.typed.ActorSystem
import akka.http.scaladsl.server.{Directives, RequestContext, Route, RouteResult}
import com.folksdev.subsciber.api.model.ModelJsonSupport

import scala.concurrent.Future

trait ApiPath extends Directives with ModelJsonSupport {

  def routes: Route
}
