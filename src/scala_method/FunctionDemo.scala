package scala_method

/**
  * 函数式编程
  * 1、将函数赋值给变量
  * 2、匿名函数
  * 3、高阶函数
  *     函数作为参数传递
  *     函数作为返回值
  * 4、闭包
  * 5、柯里化
  *
  */
object FunctionDemo {
  def main(args: Array[String]): Unit = {
    /*
    将函数赋值给变量
    不要书写 ()
     */
    val say = printStr _
    say("scala")

    /*
    匿名函数
     */
    val hello = (name:String) => {
      println("匿名招呼：hello " + name )
    }
    hello("wangWu")

    /*
    高阶函数调用
     */
    println("*************************")
    val moring = goodMorning _
    sayHello(moring,"小红")

    sayHello(goodNight,"小丽")
    println("*************************")

    val sayNoon = goodAfternoon("吃了吗")
    sayNoon("小微")

    println("*************************")
    println(sum(3,5))

    println("*************************")
    println(sum1(3)(5))

    println("*************************")
    println(sum2(3)(5))
  }

  def printStr(name:String):Unit={
    println("hello , " + name)
  }

  def goodMorning(name:String):Unit={
    println("早安！"+ name)
  }

  def goodNight(name:String):Unit={
    println("晚安！"+ name)
  }

  /**
    * 函数作为参数
    * @param func
    * @param name
    */
  def sayHello(func:(String) => Unit,name:String): Unit ={
    func(name)
  }

  /**
    * 函数作为返回值
    * @param str
    * @return
    */
  def goodAfternoon(str:String)={
    (name:String) => println("中午好！" + name + ", " + str)
  }


  /**
    * 两个参数的函数
    * @param num1
    * @param num2
    * @return
    */
  def sum(num1: Int,num2:Int)={
    num1 + num2
  }

  /**
    * 柯里化
    * 定义第一个参数 返回第二个参数
    * @param num1
    * @return
    */
  def sum1(num1:Int ) = {
    (num2:Int) => num1 + num2
  }

  def sum2(num1:Int)(num2:Int)= {
    num1 +num2
  }


}
