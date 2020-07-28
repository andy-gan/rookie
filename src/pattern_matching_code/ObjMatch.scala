package pattern_matching_code

import scala.util.Random

/**
  * 模式匹配：类型匹配
  */

class ObjMatch{}
object ObjMatch {
  def main(args: Array[String]): Unit = {

    val array = Array("hadoop",22,100.00,ObjMatch,true)
    // 随机获取一个元素
    val value = array(Random.nextInt(array.length))
    println("随机获取的值：" + value)
    value match {
      case a:Int => println(a +" Int 类型")
      case b:Double => println(b +" Double 类型")
      case c:String => println(c +" String 类型")
      //case d:Boolean => println(d +" bool 类型")
      case e:ObjMatch => println(e +" ObjMatch 类型")
      case _ => println("没有匹配")
    }

  }
}
