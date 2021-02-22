package com.folksdev.subsciber.api

import scala.concurrent.ExecutionContext

trait Components {

  implicit def executionContext: ExecutionContext

  lazy val topicsPaths: ApiPath = new TopicPaths()
  lazy val subscriberPaths: ApiPath = new SubscribersPath()
  lazy val swaggerPaths: ApiPath = new SwaggerPaths()
  lazy val supportedPaths = Seq(topicsPaths, subscriberPaths, swaggerPaths)

  lazy val apiPaths: ApiPath = new Paths(supportedPaths)
}
