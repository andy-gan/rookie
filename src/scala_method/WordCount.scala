package scala_method

/**
  * 词频统计
  */
object WordCount {
  def main(args: Array[String]): Unit = {
    val strArr = Array("How To Cover Your Tracks On The Internet","You Have Only One Life","How to Prevent Online Identity Theft")

    println(strArr.flatMap(el =>{
      el.split(" ")
    }).toBuffer)


    println(strArr.flatMap(el =>{
      el.split(" ")
    }).toList.groupBy(x=>x))

    println(strArr.flatMap(el =>{
      el.split(" ")
    }).toList.groupBy(x=>x).map(el=> (el._1,el._2.length)).toList)
  }



}
