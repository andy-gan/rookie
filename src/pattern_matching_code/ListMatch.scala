package pattern_matching_code

/**
  * 模式匹配：数组，元组，集合
  */
object ListMatch {
  def main(args: Array[String]): Unit = {

    /*
    匹配数组
     */
    val arr = Array("boy","scala","aa","bb")

    println("输入的参数值：" + arr.toBuffer)

    arr match{
      case Array("scala") => println("study scala!")
      case Array(girl1,girl2,girl3) => println("hello,小姐姐")
      case Array("boy",_*) => println("以 boy 开头的数组")
      case _ => println("不识别！")
    }

    println()
    println("*****************************************")
    println()
    /*
    匹配集合
     */
    val list = List("彭于晏","王丽坤","彭于晏","杨幂")

    list match {
        // 判断集合头部,尾部为空
      case "王丽坤"::Nil => println("hi," + list(0))
      case "彭于晏":: tail => println(list)
      case _ => println("不识别")
    }

    /*
    匹配元组
     */

    val tuple = Tuple3(1,5,"py")
    tuple match {
      case (x,3,y) => println("数据："+ x,3,y)
      case (_,x,"py") => println("数据：" + x)
      case _ => println("不识别")
    }

  }

}
