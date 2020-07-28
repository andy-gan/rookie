package com.rookie.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * spark 算子练习
  */
// 需求创建一个 1-10 数组的RDD,将所有的元素*2 返回一个新的RDD
object Spark2_Oper {
  def main(args: Array[String]): Unit = {
    // 配置文件conf
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("makeRDD")
    // 上下文对象
    val sc: SparkContext = new SparkContext(sparkConf)

    // 创建
    val lineRDD: RDD[Int] = sc.makeRDD(1 to 10)
    // 转换
    val mapRDD: RDD[Int] = lineRDD.map(_ * 2)
    // 打印
    mapRDD.collect().foreach(println)

    println("****************")
    // mapPartitions 操作
    val mapPartitionsRDD: RDD[Int] = lineRDD.mapPartitions(datas => {
      datas.map(_ * 20)
    })

    mapPartitionsRDD.collect().foreach(println)


  }
}
