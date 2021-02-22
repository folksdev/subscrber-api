package com.folksdev.subsciber.api

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import com.folksdev.subsciber.api.ApiPath
import com.folksdev.subsciber.api.model.{Period, Subscriber, Topic}
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.media.{Content, Schema}
import io.swagger.v3.oas.annotations.parameters.RequestBody
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.{Operation, Parameter}
import javax.ws.rs.core.MediaType
import javax.ws.rs._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

@Path("/subscribers")
class SubscribersPath(implicit val ec: ExecutionContext) extends ApiPath {


  override val routes: Route = getAll ~
    postSubscriber ~
    putSubscriber ~
    deleteSubscriber

  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  @Operation(summary = "Return all subscribers",
    responses = Array(
      new ApiResponse(responseCode = "200", description = "Successful response",
        content = Array(new Content(schema = new Schema(implementation = classOf[List[Subscriber]])))),
      new ApiResponse(responseCode = "500", description = "Internal server error"))
  )
  def getAll: Route =
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
    }

  @POST
  @Consumes(Array(MediaType.APPLICATION_JSON))
  @Operation(summary = "Create Subscriber",
    requestBody = new RequestBody(content = Array(new Content(schema = new Schema(implementation = classOf[Subscriber])))),
    responses = Array(
      new ApiResponse(responseCode = "201", description = "Created"),
      new ApiResponse(responseCode = "400", description = "Bad Request"),
      new ApiResponse(responseCode = "409", description = "Subscriber aldready exists!"),
      new ApiResponse(responseCode = "500", description = "Internal server error")
    )
  )
  def postSubscriber: Route =
    post {
      pathEnd {
        entity(as[Subscriber]) { subscriber =>
          println(subscriber)
          complete("POST!")
        }
      }
    }

  @PUT
  @Consumes(Array(MediaType.APPLICATION_JSON))
  @Operation(summary = "Update Subscriber",
    requestBody = new RequestBody(content = Array(new Content(schema = new Schema(implementation = classOf[Subscriber])))),
    responses = Array(
      new ApiResponse(responseCode = "202", description = "Accepted"),
      new ApiResponse(responseCode = "400", description = "Bad Request"),
      new ApiResponse(responseCode = "404", description = "Subscriber Not Found"),
      new ApiResponse(responseCode = "500", description = "Internal server error")
    )
  )
  def putSubscriber: Route =
    put {
      pathEnd {
        entity(as[Subscriber]) { subscriber =>
          println(subscriber)
          complete("PUT!")
        }
      }
    }

  @DELETE
  @Operation(summary = "Delete Subscriber",
    parameters = Array(new Parameter(name = "id", in = ParameterIn.PATH, description = "subscriber id")),
    responses = Array(
      new ApiResponse(responseCode = "202", description = "Accepted"),
      new ApiResponse(responseCode = "404", description = "Subscriber Not Found"),
      new ApiResponse(responseCode = "500", description = "Internal server error")
    )
  )
  def deleteSubscriber: Route =
    delete {
      path(Segment) { id =>
        println(id)
        complete("DELETE!")
      }
    }

}
