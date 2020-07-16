package pattern_matching_code

import extends_code.Person

/**
  * 样例类
  * 结合模式匹配 实现门禁系统
  */

class Person{}

case class Teacher(name:String,office:String) extends Person
case class Student(name:String,classroom:String) extends Person
case class Worker(name:String,office:String) extends Person

object BeanDemo {
  def main(args: Array[String]): Unit = {
    val tea:Person = Teacher("王菲","一楼教研室")
    val stu:Person = new Student("王五","101")
    val worker:Person = Worker("老王","201车间")

    door(tea)
    println()
    door(stu)
    println()
    door(worker)
    println()

    /*
    option
     */
    val map = Map("数学"-> 90,("语文",80),"英语" -> 90 )
    val value = map.get("数学") match {
      case Some(x) => x
      case None => 0
    }

    println(value)

    val i = map.getOrElse("语文",0)
    println(i)

  }

  //门禁识别
  def door(per:Person):Unit={
    println("开始识别。。。")
    per match {
      case x:Teacher => println("老师：" + x.name + ", 办公室：" + x.office)
      case y:Student => println("学生：" + y.name + ", 教室：" + y.classroom)
      //case z:Worker => println("电工：" + z.name + ", 车间：" + z.office)
      case _ => println("不能识别，非法入侵。。。")
    }
  }
}
