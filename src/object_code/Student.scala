package object_code

/**
  * 伴生类 伴生对象
  */
class Student3 private{
  // 私有默认构造器

  private[this] var _name: String = _

  def name: String = _name

  def name_=(value: String): Unit = {
    _name = value
  }

  private[this] var _age: Int = _

  def age: Int = _age

  def age_=(value: Int): Unit = {
    _age = value
  }

  //私有的全参构造器
  private def this(name:String,age:Int){
    this()
    this._name = name
    this._age = age
  }

  def study(course:String):Unit={
    println(this.name + "正在学习" + course)
  }

}

/**
  * 伴生类
  */
object Student3 {
//  val stu = new Student3()
//  stu.name = "zhangSan"
//  stu.age = 16
//  val  stu2 = new Student3("liSi",15)

  def apply(): Student3 ={
    println("伴生类apply！！！")
    new Student3()
  }

  def apply(name:String,age:Int): Student3 = {
    println("有参")
    new Student3(name,age)
  }


}

/**
  * 测试
  */
object Test{
  def main(args: Array[String]): Unit = {
    var stu = Student3()
    stu.name_=("wangWU")
    stu.age_=(17)
    stu.study("LOL")

    var stu2 = Student3("zhao6",15)
    stu2.study("cop")

  }

}






