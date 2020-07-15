package traitcode

/**
  * 接口类
  */
trait TraitD1{
  // 抽象方法
  def sayHello(str:String)

  // 具体方法
  def eat(food:String):Unit={
    println("吃" + food)
  }

  // 抽象属性
  var name:String
  //具体属性
  var age:Int = _
}

trait TraitD2{
  // 抽象方法
  def Hello():String
}
/**
  * 实现类
  */
class Child extends TraitD1{
  override def sayHello(str: String): Unit = println(str)

  override var name: String = _
}

class Child2 extends TraitD1 with TraitD2 {
  override var name: String = _
  override def sayHello(str: String): Unit = println(str)

  override def Hello(): String = "hi,boy~!"
}
object TraitDemo {
  def main(args: Array[String]): Unit = {
    val child = new Child()
    child.sayHello("HelloWorld!")

    val c2 = new Child2()
    c2.sayHello(c2.Hello())
    c2.name = "jack"
    c2.eat("青菜")
  }
}
