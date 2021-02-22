package com.folksdev.subsciber.api

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.model._

class Paths(apiPaths: Seq[ApiPath]) extends ApiPath {

  override def routes: Route = concat(apiPaths.map(_.routes):_*)

}
