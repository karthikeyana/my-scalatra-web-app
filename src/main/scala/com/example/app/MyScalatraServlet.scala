package com.example.app

import org.scalatra._
import com.mongodb.casbah.Imports._

class MyScalatraMongoServlet(mongoColl: MongoCollection) extends MyScalatraWebAppStack with SimpleMongoDbJsonConversion {

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }

  post("/insert") {
  	val key = params("key")
  	val value = params("value")
  	val newObj = MongoDBObject(key->value)
  	mongoColl += newObj
  }

  get("/users") {
  	mongoColl.find()
  	for { x <- mongoColl } yield x
  }

}
