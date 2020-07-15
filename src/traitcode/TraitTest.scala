package traitcode

/**
  * 在实例对象指定混入某个trait
  */

trait TraitLogger{
  //非抽象方法
  def log(msg:String)={
      //无方法体
  }
}

trait MyLogger extends TraitLogger{
  override def log(msg: String)={
    println("log: " + msg)
  }
}

class Person extends TraitLogger{

  var name:String = _
  def printMsg(): Unit ={
    println("hello ," + this.name)
    log(System.currentTimeMillis() + ": printMsg mtd {hello" + this.name + "}")
  }
}
object TraitTest {
  def main(args: Array[String]): Unit = {
    val per = new Person() with MyLogger
    per.name = "jack"
    // 直接执行MyLogger覆写的方法
    per.printMsg()
  }
}
