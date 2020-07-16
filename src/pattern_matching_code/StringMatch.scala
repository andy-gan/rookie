package pattern_matching_code

import scala.util.Random

/**
  * 模式匹配：字符串匹配
  */
object StringMatch {
  def main(args: Array[String]): Unit = {


    val strings = Array("python","scala","java","perl")
    // 0-4 随机或取
    val str = strings(Random.nextInt(4))
    /*
    匹配字符串
     */
    str match {
      case "pyhton" => println("python")
      case "java" => println("java")
      case "scala" => println("scala")
      case _ if str.equals("perl") => println("perl")
      case _ => println("啥也不是！")
    }


  }
}
