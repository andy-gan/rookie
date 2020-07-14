package extends_code

import scala.swing.Color

/**
  * 继承 extends
  * 1、private修饰的field和method不可以被子类继承，只能在类的内部使用
  * 2、使用final修饰符时，修饰类：类不能被继承、修饰field和method：不能被覆写
  * 三个关键字
  * final：子类不可以修改
  * private：子类不可以访问
  * protected：父类和子类中使用
  */
abstract class Person{
  // 抽象 name
  var name:String
  final var age:Int = _
  // 子类不可以访问
  private var addr:String = "中国"
  // 抽象方法
  def say:String
  def motion()
}

class Student extends Person{

  /**
    * 子类特有的方法
    * @param str
    */
  var name:String = _
  //var age = 12
  def study(str:String):Unit = {
    println(name + "正在学习" + str)
  }

  //覆写父类抽象方法
  def say: String = "hello world！"
  def motion():Unit ={
    println("跑步")
  }
}

class Phone{
  val core:String = "IOS-10001"

  def call():Unit={
    println("打电话-----")
  }
}

/**
  * super 调用父类方法
  */
class HuaWei extends Phone{
  // 复写父类方法
  override val core:String = "Android-001"
  override def call():Unit={
    println("视屏电话-----")
    println("打电话-----")
    super.call()
  }
}


class Animal{
  var name:String = _
  var color:String = _

  def this(name:String,color: String)={
    this()
    println("父类构造")
    this.name=name
    this.color=color
  }
}

class Cat(name:String,color: String) extends Animal(name:String,color: String){
  def eat(food: String): Unit ={
    println(color + name + "喜欢吃" + food)
  }
}

object Person {
  def main(args: Array[String]): Unit = {
    val stu = new Student()
    stu.name = "zhangSan"
    stu.study("python")
    stu.age = 123
    println(stu.age)

    val hero = new HuaWei()
    hero.call()

    val cat = new Cat("猫","黄色")
    cat.eat("鱼")


    println("抽象.....")
    val flag = stu.say
    stu.motion()
  }
}
