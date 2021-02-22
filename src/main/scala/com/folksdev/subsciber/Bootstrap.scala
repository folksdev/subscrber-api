package com.folksdev.subsciber

import akka.actor.typed.ActorSystem
import akka.actor.typed.javadsl.Behaviors
import akka.http.scaladsl.Http
import com.folksdev.subsciber.api.Paths

import scala.io.StdIn

trait Bootstrap extends Paths{
  override implicit def actorSystem: ActorSystem[Any] = ActorSystem(Behaviors.empty, "subscriber-api")

  implicit val executionContext = actorSystem.executionContext

  val bindingFuture = Http().newServerAt("localhost", 8080).bind(route)

  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
  StdIn.readLine() // let it run until user presses return
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => actorSystem.terminate()) // and shutdown when done
}
