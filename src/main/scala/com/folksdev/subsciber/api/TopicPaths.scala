package com.folksdev.subsciber.api

import akka.http.scaladsl.server.Route
import com.folksdev.subsciber.api.TopicPaths._
import com.folksdev.subsciber.api.model.Topic

class TopicPaths extends ApiPath {


  override def routes: Route = path("topics") {
    get {
      complete(SupportedTopics)
    }
  }
}

object TopicPaths {

  val SupportedTopics = Set(Topic.Scala, Topic.Java, Topic.SpringBoot, Topic.GoLang)

}
