package object_code

class Session{}

/**
  * 单例模式
  */
object Session {
  val session = new Session()
  def getSession()={
    session
  }

}

object SessionTest{

  def main(args: Array[String]): Unit = {

    // 不用 new 对象
    val session1 = Session.getSession()
    println(session1)

    val session2 = Session.session
    println(session2)
  }
}
