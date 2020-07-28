package com.rookie.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * spark 算子练习
  */
// 对一个RDD 操作，要求返回一个带分区号的 tuple 元组的 集合
object Spark2_Oper2 {
  def main(args: Array[String]): Unit = {
    // 配置文件conf
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("makeRDD")
    // 上下文对象
    val sc: SparkContext = new SparkContext(sparkConf)

    // 创建
    val lineRDD: RDD[Int] = sc.makeRDD(1 to 10)
    // 转换
    val mapRDD: RDD[(Int, String)] = lineRDD.mapPartitionsWithIndex((num, datas) => {
      datas.map((_, "分区号：" + num))
    })

    // 打印
    mapRDD.collect().foreach(println)



  }
}
