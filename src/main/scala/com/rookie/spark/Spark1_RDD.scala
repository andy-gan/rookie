package com.rookie.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * spark 创建
  * 1、集合
  *     makeRDD
  * 2、外部存储中创建
  */
object Spark1_RDD {
  def main(args: Array[String]): Unit = {
    // 配置文件conf
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("makeRDD")
    // 上下文对象
    val sc: SparkContext = new SparkContext(sparkConf)

    // 创建rdd
    // 从内存中创建  底层实现 parallelize 也是这个对象
    //val listRDD: RDD[Int] = sc.makeRDD(List(1,2,3))
    //自定义分区
    val listRDD: RDD[Int] = sc.makeRDD(List(1,2,3),2)
    listRDD.foreach(println)

    // parallelize
    val arrayRDD: RDD[Int] = sc.parallelize(Array(1,2,3))
    arrayRDD.foreach(println)


    // 外部数据集创建
    // 默认情况读取的数据都是 字符串
    val fileRDD: RDD[String] = sc.textFile("data/in",2)
    fileRDD.foreach(println)


    // 数据存储到文件中
    // listRDD.saveAsTextFile("data/output")
    fileRDD.saveAsTextFile("data/output")

  }
}
