package com.folksdev.subsciber.api

import akka.http.scaladsl.server.{Directives, Route}
import com.folksdev.subsciber.api.model.ModelJsonSupport

trait ApiPath extends Directives with ModelJsonSupport {

  def routes: Route
}
