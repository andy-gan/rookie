package object_code

/**
  * 定义
  * 构造
  * 访问权限
  */
class Person{

  /**
    * val 定义的成员变量 相当于对外提供了getter 方法
    * var 定义的成员变量 相当于对外提供了getter 和 setter 方法
    */
  var name = "zhangSan"
  val age = 15

  def eat():Unit={
    println(name + "在吃早饭！")
  }

}

/**
  * 每个类都有主构造器，主构造器的参数直接放置类名后面，与类交织在一起默认为val 定义
  * scala类中所使用的占位符”_”，只有在声明var变量时才可以使用
  * @param n
  * @param a
  */
class Student(n:String,a:Int){
  val name = n

  var age: Int = a
  //申明变量类型， _占位符号
  var sex:String = _

  println("主构造器默认执行类型定义的所有的方法")

  def this(n:String,a:Int,sex:String){
    //主构造器放在前面
    this(n,a)
    println("辅构造器执行！")

    this.sex = sex
  }

  def study(S:String):Unit={
    println(name + "正在学习" + S)
  }

}

/**
  * 权限控制
  * class Student2 private (n:String,a:Int) 私有构造器
  * 在主构造器或辅构造器修饰为private后，访问权限仅限：本类和伴生对象中使用
  * @param n
  * @param a
  */
class Student2 private (n:String,a:Int){
  val name:String = n

  var age: Int = a
  //申明变量类型， _占位符号
  var sex:String = _

  println("主构造器默认执行类型定义的所有的方法")

  def this(n:String,a:Int,sex:String){
    //主构造器放在前面
    this(n,a)
    println("辅构造器执行！")

    this.sex = sex
  }

  def study(S:String):Unit={
    println(name + "正在学习" + S)
  }

}

/**
  * 成员私有化
  * 使用getter 和 setter方法 访问和设置私有变量
  */
class Person2{

  private[this] var _name: String = _

  def name: String ={
    println("name getter")
    _name
  }

  def name_=(value: String): Unit = {
    _name = value
    println("name setter")
  }

  private[this] var _age: Int = _

  def age: Int = {
    println("age getter")
    _age
  }

  def age_=(value: Int): Unit = {
    _age = value
    println("age setter")
  }

  def eat():Unit={
    println(this._name + "在吃早饭！")
  }





}


object ObjectTest {
  def main(args: Array[String]): Unit = {
    val person = new Person()

    println(person.name)
    person.name = "liSi"
    println(person.name)
    println(person.age)
    person.eat()

    println("*******************************")
    val stu = new Student("zhangSan", 15)
    stu.age = 17
    println(stu.age)
    println(stu.sex)
    stu.study("java")

    println("*******************************")
    val stu2 = new Student("liSi", 18 ,"女")
    println(stu2.sex)
    stu2.study("python")

    println("*******************************")

    //val stu3 = new Student2("张三",12)
    val stu3 = new Student2("张三",12,"男")
    stu3.study("scala")

    println("*******************************")
    val per2 = new Person2()
    per2.eat()

    val per3 = new Person2()
    per3.name_=("jack")
//    per3.age_=(18)
//    println(per3.name)
//    println(per3.age)

    //    per3.age_=(18)
    //    println(per3.name)
    //    println(per3.age)
    per3.eat()


  }
}
