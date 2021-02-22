package com.folksdev.subsciber.api

import scala.concurrent.ExecutionContext

trait Components {

  implicit def executionContext: ExecutionContext

  lazy val topicsPaths: ApiPath = new TopicPaths()
  lazy val subscriberPaths: ApiPath = new SubscriberPaths()
  lazy val supportedPaths = Seq(topicsPaths, subscriberPaths)

  lazy val apiPaths: ApiPath = new Paths(supportedPaths)
}
