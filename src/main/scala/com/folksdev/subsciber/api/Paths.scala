package com.folksdev.subsciber.api

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.model._

trait Paths extends ApiPath {

  val topicPaths: ApiPath = new TopicPaths()

  override def routes: Route = concat(
    path("hello") {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Subscriber Api With Akka Http</h1>"))
      }
    },
    topicPaths.routes
  )

}
