package scala_method

/**
  * 常用的高阶函数
  */
object FunctionDemo2 {
  def main(args: Array[String]): Unit = {
    /*
    map :遍历集合，接入的是一个函数，返回处理后的值
     */

    val arr = Array(1,3,4,11,5,7,8,9)
    val arrayMap = arr.map(el => {
      var t = el + 1
      t = t * 10
      t
    })
    println(arrayMap.toBuffer)

    val result = (1 to 10 ).map(x => {
      if (x % 2 == 0){
        (x,"偶数")
      }else{
        (x,"基数")
      }
    })
    println(result)

    /*
      foreach 处理每一个元素，不返回值
     */
    arrayMap.foreach(x => print("\t" + x))

    /*
    filter函数： 对传入的每个元素都进行条件判断，条件为true，则保留该元素，否则过滤掉该元素
     */

    println()
    println("****************************")
    val filterMap = arrayMap.filter(x => {
      if(x % 2 == 0 && x > 50){
        true
      }else{
        false
      }
    } )
    println(filterMap.toBuffer)

    /*
    reduceLeft函数 : 接受两个元素，并返回一个元素作为下次参数组的第一个参数
     */
    val arrRed = arr.reduceLeft((x,y) =>{
      x+y
    })
    println(arrRed)

    /*
    flatMap函数：将多行子句拆分成单词,将所有的集合处理成一个
     */

    val arr1 = Array("hello kitty","hello world")
    val list = List("你好 中国","你好")
    val newList = arr1.toList ++ list
    val listFlatMap = newList.flatMap(el => {
      if (el.length()>3){
        el.split(" ")
      }else{
        ""
      }
    })
    println(listFlatMap)

    /*
    zip函数：拉链操作，将多个值进行关联
     */
    val name = Array("zhang","li","zhao","wang")
    val age = Array(15,15,16)

    val listZip = name.zip(age)
    println(listZip.toBuffer)
    val listZipAll = name.zipAll(age,"默认",0)
    println(listZipAll.toBuffer)

  }
}
