package scala_code

/**
  *  1.scala object相当于java中的单例，object 中定义的全是静态的
  *  2. val 定义常量不可变
  *     var 定义变量
  *  3.Scale类中可以传参，传参需要指定类型,有了参数就有了默认的构造，；类中的属性默认有getter和setter方法
  */


/**
  * 1.函数中的参数默认是使用val定义，不能对参数的值进行修改
  * 2.匿名函数
  *
  */

class Person(xname:String,xage:Int){
  val name  = xname
  val age = xage
  var sex:String = _


}
object TestScala {
  /**
    * 无返回值函数
    * 传参为val 不能修改
    * @param num
    */
  def function(num: Int):Unit={
//    num = 8 报错
    println(num)
  }


  /**
    * 有返回值的函数
    * 指定返回值类型
    * @param num1,num2
    */
  def add1(num1:Int,num2:Int): Int ={
    return num1 + num2
  }

  /**
    * 省略返回值类型
    * 不加 return
    * @param num1
    * @param num2
    */
  def add2(num1:Int,num2:Int) = {
    val sum = num1 + num2
    sum
  }

  /**
    * 省略函数体
    * 函数体只有一行时可以这样简写
    * @param num1
    * @param num2
    * @return
    */

  def add3(num1:Int,num2:Int) = num1 + num2

  /**
    * 匿名函数的使用
    */
  val sum = (num1:Int,num2:Int) =>{
    if (num1 != num2)
    {
      num1 + num2

    }
  }

  /**
    * 默认参数使用
    * 1.无值使用默认值，有值使用传入的值
    * @param name
    * @param sex
    */
  def parameterDemo(name: String,sex:String="男"):Unit ={
    println("name : " + name + ", sex : " + sex)
  }

  /**
    * 带名参数
    * @param age
    * @param str
    */
  def parameterDemo1(age: Int,str:String):Unit ={
    println("str : " + str + ", age : " + age)
  }

  /**
    * 可变参数
    * @param args
    */
  def parameterDemo2(strs:String*):Unit ={
    for(str <- strs){
      println("str : " + str)
    }

  }

  def main(args: Array[String]): Unit = {
//    val a = 1
//    var b = 2
//
//    b = 3
//    println(a)
//    println(b)
//
//    val p = new Person(xname = "zhangsan", xage = 16)
//    println(p.name)
//    println(p.age)
//
//    // 9*9 乘法表
//
//    for( i <- 1 to 9){
//      for( j <- 1 to i){
//         print(j + " * "+ i +"  = " + (i*j) + "\t")
//
//      }
//      println()
//    }
//
//    // 语法快
//
//    val result = {
//      val a = 5
//      val b = 7
//      a + b
//    }
//    println(a)
//    println(b)
//    println(result)



//    val num = 7
//    function(num)
//    val num1 = 2
//    val num2 = 3
////    val sum = add1(num1,num2)
//    println(add1(num1,num2))
//    println(add2(num1,num2))
//    println(add3(num1,num2))
//
//    println(sum(10, 20))

    parameterDemo("张三")
    parameterDemo("王五","女")
    parameterDemo1(str="ZhangSan",age=16)
    parameterDemo2("hadoop","python","hive")
  }


}
