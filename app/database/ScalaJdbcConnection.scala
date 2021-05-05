package database

import javax.inject.Inject
import play.api.db.Database

import java.sql.{Connection, Statement}
import scala.concurrent.Future

class ScalaJdbcConnection @Inject() (db: Database, databaseExecutionContext: DatabaseExecutionContext) {
  def updateSomething(): Unit = {

    Future {

      try {
        val connection: Connection = db.getConnection()
        connection.close()
      } catch {
        case x: Exception => println("\n\n\nException")
      }

      val connection: Connection = db.getConnection()

      print(s"\n\n\n\ngot to update something Connection:$connection\n\n DB Name: ${db.name}")

      val sqlQuery: String = "SELECT * FROM Vocabulary"

      val statement: Statement =  connection.createStatement()

      statement.executeQuery(sqlQuery)

      connection.close()
    }(databaseExecutionContext)
  }
}