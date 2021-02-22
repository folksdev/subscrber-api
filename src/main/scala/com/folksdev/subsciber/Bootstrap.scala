package com.folksdev.subsciber

import akka.actor.typed.ActorSystem
import akka.actor.typed.javadsl.Behaviors
import akka.http.scaladsl.Http
import com.folksdev.subsciber.api.Components

import scala.concurrent.ExecutionContext
import scala.io.StdIn

trait Bootstrap extends Components {

  implicit def actorSystem: ActorSystem[Any] = ActorSystem(Behaviors.empty, "subscriber-api")


  override implicit def executionContext: ExecutionContext = actorSystem.executionContext

  val bindingFuture = Http().newServerAt("localhost", 8080).bind(apiPaths.routes)

  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
  StdIn.readLine() // let it run until user presses return
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => actorSystem.terminate()) // and shutdown when done
}
