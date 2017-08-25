import com.mongodb.casbah.Imports._
import com.example.app._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
  	val mongoClient = MongoClient()
  	val mongoColl = mongoClient("scalaDB")("user")
    context.mount(new MyScalatraMongoServlet(mongoColl), "/*")
  }
}
