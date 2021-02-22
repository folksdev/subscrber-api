package com.folksdev.subsciber.api

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import com.folksdev.subsciber.api.model.{Period, Subscriber, Topic}

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

class SubscriberPaths(implicit val ec: ExecutionContext) extends ApiPath {


  override def routes: Route = pathPrefix("subscribers") {
    concat(
      get {
        pathEnd {
          val subscribersFuture: Future[List[Subscriber]] = Future(List(
            Subscriber(1, "a", Period.Weekly, Set(Topic.GoLang, Topic.Scala))
          ))

          onComplete(subscribersFuture) {
            case Success(subscribers) => complete(subscribers)
            case Failure(exception) => complete(StatusCodes.NotFound, exception.getMessage)
          }
        }
      },
      post {
        pathEnd {
          entity(as[Subscriber]) { subscriber =>
            println(subscriber)
            complete("POST!")
          }
        }
      } ,
      put {
        pathEnd {
          entity(as[Subscriber]) { subscriber =>
            println(subscriber)
            complete("PUT!")
          }
        }
      },
      delete {
        path(Segment) { id =>
          println(id)
          complete("DELETE!")
        }
      }
    )
  }
}
