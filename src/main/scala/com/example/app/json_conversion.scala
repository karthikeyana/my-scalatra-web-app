package com.example.app

import org.scalatra._
import com.mongodb.casbah.Imports._

trait SimpleMongoDbJsonConversion extends ScalatraBase with ApiFormats {

  def renderMongo = {
    case dbo: DBObject =>
      contentType = formats("json")
      dbo.toString

    case xs: TraversableOnce[_] =>
      contentType = formats("json")
      val l = xs map (x => x.toString) mkString(",")
      "[" + l + "]"

  }: RenderPipeline

  override protected def renderPipeline = renderMongo orElse super.renderPipeline

}
