package com.rookie.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * spark 算子练习
  * repartition(numPartitions) 重新分区
  * 需求：创建一个四个分区的RDD，对其缩减分区
  */
// 需求：创建一个RDD, 过滤奇数
object Spark2_Oper10 {
  def main(args: Array[String]): Unit = {
    // 配置文件conf
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("makeRDD")
    // 上下文对象
    val sc: SparkContext = new SparkContext(sparkConf)

    // 创建
     val listRDD: RDD[Int] = sc.makeRDD(List(1,3,2,4,1,7,6,7,3,9),8)
    listRDD.glom().foreach(arr => println(arr.toBuffer))
    // 重新分区
    val repartitionRDD: RDD[Int] = listRDD.repartition(2)
    // 打印
    val glomRDD: RDD[Array[Int]] = repartitionRDD.glom()

    glomRDD.foreach(arr => println(arr.toBuffer))




  }
}
