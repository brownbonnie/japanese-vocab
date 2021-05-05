package controllers

import javax.inject._
import play.api.mvc._
import database.ScalaJdbcConnection

import scala.concurrent.Future

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(
                                cc: ControllerComponents,
                                db: ScalaJdbcConnection
                              ) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def explore() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.explore())
  }

  def tutorial() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.tutorial())
  }

  def hello() = Action.async { implicit request: Request[AnyContent] =>
    db.updateSomething()

    Future.successful(Ok(views.html.hello()))
  }
  
}
