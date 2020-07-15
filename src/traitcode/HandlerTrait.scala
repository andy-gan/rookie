package traitcode

/**
  * trait 调用链
  */
trait HandlerTrait{
  println("HandlerTrait 构造器！！！")
  def handler(data:String): Unit ={
    println("HandlerTrait " + data)
  }
}

trait SignatureValHandlerTrait extends HandlerTrait{
  println("SignatureValHandlerTrait 构造器！！！")
  override def handler(data: String): Unit = {
    println("check Signature: " + data)
    super.handler(data)
  }
}

trait DataValidHandlerTrait extends HandlerTrait{
  println("DataValidHandlerTrait 构造器！！！")
  override def handler(data: String): Unit = {
    println("check Data: " + data)
    super.handler(data)
  }
}

class PersonRequest(val data:String) extends SignatureValHandlerTrait with DataValidHandlerTrait{
  def getParamter={
    println("参数：" + data)
    handler(data)
  }
}

/**
  * 模板设计模式
  * 可以让具体方法依赖于抽象方法，而抽象方法则可放到继承trait的子类中去实现，这种 trait特性
  */

trait ValidTrait{
  println("ValidTrait 构造器！！！")
  def getName:String

  def valid(data:String):Boolean={
    data.equals(this.getName)
  }
}

class PersonRequest1(val data:String) extends ValidTrait{
  override def getName: String = {
    this.data
  }
}

/**
  * trait中 field 实例化
  * 方式1 混入
  * 方式2 多重继承
  */

trait TraitHello{
  val msg:String
  println("消息的长度：" + msg.length())
}

class MyTrait1 extends TraitHello{
  override val msg: String = "初始化"
}


class MyTrait2 extends {val msg:String = "继承初始化"} with TraitHello{
//  override val msg: String = "初始化"
}



object HandlerTraitTest {
  def main(args: Array[String]): Unit = {
    val request = new PersonRequest("admin")
    request.getParamter

    println("*******************************************")
    println("*******************************************")
    println()

    val req1 = new PersonRequest1("有朋自远方来")

    if(req1.valid("有朋自远方来"))
    {
      println("开门")
    }else{
      println("不放行")
    }
    println()
    println("*******************************************")
    println("*******************************************")
    println()

    var t1 = new {override val msg:String="初始化"} with MyTrait1

    val t2 = new MyTrait2()
  }
}
