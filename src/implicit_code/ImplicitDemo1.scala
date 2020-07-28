package implicit_code

/**
  * 隐式转换
  */
/**
  * 定义样例类：样例类可以进行类型匹配
  */
case class Student(name:String)
case class Soldiery(name:String)
case class SpecialPerson(name:String)
object ImplicitDemo1 {
  /**
    * 定义隐式转换函数
    * @param obj
    * @return
    */
  implicit def Student2Programmer(obj:Object): SpecialPerson={
    obj match {
      case Student(name) =>{
        println(obj)
        new SpecialPerson(name)
      }
      case Soldiery(name) =>{
        println(obj)
        new Soldiery(name)
      }
    }

  }

}

object Student{
  def main(args: Array[String]): Unit = {
    import ImplicitDemo1._
    val stu = new Student("zhangSan")
    buyTicket(stu)

    val sol = new SpecialPerson("wangbaoqiang")
    buyTicket(sol)
  }

  //买票
  def buyTicket(sp:SpecialPerson):Unit ={
    println("特殊人群：" + sp.name + "可以买票！")
  }
}