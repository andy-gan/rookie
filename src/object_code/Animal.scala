package object_code

/**
  * apply 实现单例
  */

class Animal private{
  private[this] var _name: String = _

  private def name: String = _name

  private def name_=(value: String): Unit = {
    _name = value
  }

  def this(name:String)={
    this()
    this._name = name

  }

  def eat(food:String):Unit ={
    println(this._name + "正在吃" + food)
  }

}

object Animal {
  var ani:Animal  = null

  def apply(name:String): Animal = {
    if (ani == null)
      {
        println("初始化！！")
        ani = new Animal(name)
      }
    ani
  }

}


object AniTest{
  def main(args: Array[String]): Unit = {
    val cat = Animal
    println(cat)

    val cat1 = Animal("猫")
    cat1.eat("鱼")

  }
}