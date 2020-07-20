package implicit_code

/**
  * 隐式转换增强
  */

class Man(n:String){
  val name:String = n
  def work():Unit ={
    println(name + "正在努力工作。。。。。")
  }
}

class SuperMan(name:String){
  def fly():Unit={
    println(this.name + "飞走了。。。。。")
  }
}
object ImplicitDemo2 {

  implicit def manToSuperMan(man:Man):SuperMan = new SuperMan(man.name)

  def main(args: Array[String]): Unit = {
    val man: Man = new Man("jack")
    man.work()
    man.fly()
  }
}
