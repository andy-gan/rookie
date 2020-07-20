package implicit_code

/**
  * 隐式参数
  * Scala会在两个范围内查找：
    1、当前作用域内可见的val或var定义的隐式值
    2、隐式参数类型的伴生对象内的隐式值
  */
object Company {

  implicit var name:String = "张三"
  implicit var money:Double = 1234.00
}

class Boss {

  def getName()(implicit name:String):String ={
    name + " coming"
  }

  def getMoney()(implicit money:Double):String ={
    "当月薪资：" + money
  }
}

object Boss {
  def main(args: Array[String]): Unit = {

    println("******")
    import Company._
    val boss = new Boss()
    println(boss.getName() + "," + boss.getMoney())
  }
}

