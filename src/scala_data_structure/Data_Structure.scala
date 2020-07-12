package scala_data_structure


import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}


object Data_Structure {

  /**
    * 获取数组中的最大的值
    * @param arr
    * @return
    */
  def max_Arr(arr:Array[Int]): Int={
    var max = arr(0)

    for (i <- arr){
      if (i > max) {
        max = i
      }
    }
    return max

  }

  /**
    * 数组
    */
  def array_demo():Unit={
    /**
      * 数组的定义
      * 1 new Array[Int](3) 默认值为0
      * 2 Array("Java","Python","Scala")
      */
    var arr = new Array[Int](3)
    arr(0) = 1
    arr(1) = 3
    println(arr(0))
    println(arr(1))
    println(arr(2))

    /**
      * 数组的方法
      * 1. Array.length  返回数组的长度
      * 2. Array.map(_*10) 遍历出数组中的每一个元素 并返回一个新的元素
      * 3. Array.sum 求和
      * 4. Array.max 最大值
      * 5. Array.min 最小值
      * 6. Array.sorted 排序 默认升序 返回一个新的数组
      * 7. Array.sortWith(_>_) 指定比较
      * 8. Array.mkString(seq:String) 将原数组使用特定的字符串seq分割。
      *    Array.mkString(start:String,seq:String,end:String) 将原数组使用特定的字符串seq分割的同时，在原数组之前添加字符串start，在其后添加字符串end。
      *    元素转化为字符串，可能还会添加分隔符，前缀，后缀。
      */

    var arr2 = Array("Java","Python","Scala")
    println("数组的长度："+ arr2.length)

    //遍历数组
    for (str <- arr2) {
      println(str)
    }

    var arr3 = new Array[Int](5)

    arr3(0) = 5
    arr3(1) = 1
    arr3(2) = 3
    arr3(3) = 9
    arr3(4) = 7

    // 获取数组中最大的值
    println(max_Arr(arr3))

    /*
        yield 关键字的使用 返回一个新的数组
     */
    println("***************")
    val arr4 = for( i <- arr ) yield i*100

    for (a <- arr4) {
      println(a)
    }

    /*
    map() 方法的使用
     */
    println("***************")
    val arr5 = arr.map(_*10)
    for (a <- arr5) {
      println(a)
    }

    /*
    常用方法
    sum
    max
    min
    sorted
    sortWith()
    集合元素转化为字符串，可能还会添加分隔符，前缀，后缀。
    mkString(seq:String)
    mkString(start:String,seq:String,end:String)
     */
    println("***************")
    println("数组中元素的和："+ arr3.sum)
    println("数组中最大的元素："+ arr3.max)
    println("数组中最小的元素："+ arr3.min)

    println("***************")

    println("排序")
    println()
    val sortArr3 = arr3.sorted // 默认升序
    println("数组排序前：")

    for (i <- arr3) print(i + "\t")
    println()
    println("数组排序后：")

    for (i <- sortArr3) print(i + "\t")

    // 数组排序比较函数‘

    val sortArr3_2 = arr3.sortWith(_>_) // 第一元素大于第二个元素
    println()
    println("数组从大到小排序后：")
    for (i <- sortArr3_2) print(i + "\t")

    println()

    //mkString 集合元素转化为字符串，可能还会添加分隔符，前缀，后缀。
    println("***************")
    println("数组转字符串 ")

    println(arr2.mkString("-"))

    println(arr2.mkString("Array(",",",")"))


    /**
      * 变长数组： ArrayBuffer
      * 使用： 当数组中所存储元素的个数不固定时使用变长数组
      */
    println("***************")
    println("变长数组 ")

    val arrBuff = new ArrayBuffer[Int]()

    /**
      * 数组操作
      * 1.添加元素
      *   arrBuff += 1  追加一个
      *   arrBuff += (1,2,3) 追加多个
      *   arrBuff ++= Array(100,200,300) 追加数组
      *   arrBuff ++= ArrayBuffer(600,700,800) 追加数组
      * 2.toBuffer() 把不可变数组Array转换为可变数组ArrayBuffer
      * 3.arrBuff.append(a) 添加元素 尾部
      * 4.arrBuff.insert(0,22,33) 指定位置添加元素
      * 5.arrBuff.remove(0)  删除指定位置的元素
      *   arrBuff.remove(0,3) 从指定位置的元素，删除3个
      */
    arrBuff += 5
    arrBuff += (1,2,3)

    arrBuff ++= Array(100,200,300)
    arrBuff ++= ArrayBuffer(600,700,800)

    for (i <- arrBuff ) print(i + "\t")
    println()
    println(arrBuff)

    // 尾部添加
    arrBuff.append(778)
    arrBuff.append(90,18)
    println(arrBuff)

    // 指定位置
    arrBuff.insert(0,22,33)
    println(arrBuff)
    // 删除 按下标删除
    arrBuff.remove(0)
    println(arrBuff)
    // 从0 开始 删除3个
    arrBuff.remove(0,3)
    println(arrBuff)
  }

  /**
    * 元组
    */
  def tupleDemo():Unit={
    /**
      * 元组的创建
      * 元组的长度最大为22
      */

    val t1 = ("hello",12,3.14)

    println(t1)

    val t2 = new Tuple2(1,33)
    println(t2)

    /**
      * 元组的值的获取
      */
    println("****************")
    println(t1._1)
    println(t1._2)


  }

  /**
    * list 集合
    */
  def listDemo():Unit={
    /**
      * 集合的定义
       */

    var list1 = List[Int](1,3)

    println(list1)
    // 空集合
    var list2 = Nil
    println(list2)

    println("******************")
    val list3 = List("python",1,"java")

    println("集合的头部："+list3.head)
    //除了第一个元素  都是尾部
    println("集合的尾部："+list3.tail)


    /**
      * 集合添加元素
      * 1、头部添加
      *    +:
      *    ::  添加的元素写在前面
      *    .+:()
      *    .::()  添加的元素写在后面
      * 2、尾部添加
      *    :+ 添加的元素写在后面
      *
      * 3、集合之间合并
      *  l1 ++ l2 两集合合并
      *  l1 ++: l2 将l1 插入在l2 的前面
      *  l2.:::l1 将 l1 插入在类 的前面
      */
    println("******************")
    // 头部添加元素
    val list4 = 1 +: list3
    val list5 = 1 :: list3
    println("list4:" + list4)
    println("list5:" + list5)

    val list6 = list3.+:(1)
    val list7 = list3.::(2)
    println("list6:" + list6)
    println("list7:" + list7)

    println("******************")
    // 尾部添加元素
    val list8 = list3 :+ 3
    val list9 = list3.:+(6)
    println("list8:" + list8)
    println("list9:" + list9)

    //集合合并
    val list10 = List("hello ")
    val list11 = List("world !")
    val list12 = list10 ++ list11
    println("list 合并 ：" + list12)

    //头部添加集合
    val list13 = list10 ++: list11
    val list14 = list11.:::(list10)
    println("list头部插入 list ：" + list13)
    println("list头部插入 list ：" + list14)


    println("******************")

    /**
      * 可变list
      *
      */
    // 初始化
    val listbuf1 = ListBuffer(1,2,3)
    // 空集合
    val listbuf2 = ListBuffer[Int]()

    println(listbuf1)
    println(listbuf2)

    /**
      * 元素添加
      * 1、尾部添加
      *   +=
      *   buf.append()
      * 2、指定角标
      *   buf.insert(1,12) 添加一个
      *   buf.insert(1,1,2,3) 添加多个
      * 集合合并
      * 1、返回新的集合
      *   buf1 ++ buf2
      * 2、不返回新的集合
      *   buf1 ++= buf2
      */
    println("******************")
    println("可变list元素添加")

    listbuf2 += 1
    println(listbuf2)
    listbuf2.append(5)
    println(listbuf2)

    listbuf2.insert(1,8)
    println(listbuf2)
    listbuf2.insert(0,1,2,3,4,5)
    println(listbuf2)

    println("******************")
    println("可变list合并")

    val listbuf3 = ListBuffer(1,2,4)
    val listbuf4 = ListBuffer(100,200,300)
    // 在集合后追加
    listbuf3 ++= listbuf4
    println(listbuf3)

    // 返回新的集合
    val newbuf = listbuf3 ++ listbuf4
    println(newbuf)




  }

  /**
    * set 集合
    */
  def setDemo():Unit={
    /**
      * set 集合的定义1
      */

    val set1 = Set(1,3,5,4,1,3)
    println("set1:" + set1)

    println("*******************")
    //添加元素
    val set2 = set1 + (6,7,1)
    println("set2:" + set2)

    println("*******************")

    //删除元素
    val set3 = set2 - (1,3)
    println("set3: " + set3)

    //set级别操作
    val set4 = set1 ++ set2
    println("set4: " + set4)

    //集合交集
    val set5 = set3 & set1
    println("set5: " + set5)

    println("*******************")
    println("可变set")

    val setbuf = mutable.Set(3,4,5)
    println("setbuf: " + setbuf)

    //添加元素
    setbuf.add(1)
    setbuf.+=(2)
    println(setbuf)

    //删除元素
    println(setbuf.remove(0))
    setbuf.-=(2)

    println(setbuf)

    //合并
    val setbuf2 = mutable.Set(7,4,9)
    setbuf.++=(setbuf2)
    println(setbuf)


  }

  /**
    * map 集合
    */
  def mapdemo():Unit={
    /**
      * map 定义
      */

    val map1 = Map("name"->"zhangsan", "age"->15)
    println(map1)
    /*
    添加新的kv 生成新的map
     */
    val map2 = map1.+("c_no"->"C01")
    println(map2)
    /*
    删除元素
     */
    val map3 = map2.-("c_no")
    println(map3)

    /*
    获取元素
    v 的类型为 option 可选值
     */
    val v1 = map2.get("name")
    println("value: " + v1)

    val v2 = map3.get("c_no")
    println("value: " + v2)

    /**
      * 可变 map
      */

    println("********************")

    val mapBuf1 = mutable.Map("name"->"zhangsan", "age"->15)
    println(mapBuf1)

    val mapBuf2 = mutable.Map("c_name"->"Java", "c_no"->"C01")
    println(mapBuf2)

    /*
    遍历
     */
     for(k <- mapBuf1.keys){
       println("key: " + k + "----- value:" + mapBuf1.get(k))
     }

    mapBuf1.keys.foreach{
      k =>
        println("key: "+ k)
        println("value: " + mapBuf1.get(k))
    }

    /*
    合并集合
     */
    mapBuf1.++=(mapBuf2)
    println(mapBuf1)

    /*
    添加 k v
     */
    mapBuf2("aaw") = "www"
    println(mapBuf2)

    mapBuf2.put("tt","waw")
    println(mapBuf2)

    mapBuf2.+=("qqq"->"123")
    println(mapBuf2)

    /*
    删除元素
     */
    mapBuf2.remove("qqq")
    mapBuf2.-=("tt")

    println(mapBuf2)

  }
  def main(args: Array[String]): Unit = {

    /*
    数组
     */

    // array_demo()

    /*
    元组
     */

    //tupleDemo()

    /*
    集合
     */

    //listDemo()

    /*
    set集合
     */
    //setDemo()

    /*
    map 集合
     */
    mapdemo()
  }
}
