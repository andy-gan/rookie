package com.rookie.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * spark 算子练习
  */
// 对一个RDD 操作，要求返回一个带分区号的 tuple 元组的 集合
object Spark2_Oper3 {
  def main(args: Array[String]): Unit = {
    // 配置文件conf
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("makeRDD")
    // 上下文对象
    val sc: SparkContext = new SparkContext(sparkConf)

    // 创建
    val lineRDD: RDD[List[Int]] = sc.makeRDD(List(List(1,3),List(7,8)))
    // 转换
    val flatMapRDD: RDD[Int] = lineRDD.flatMap(datas=>datas)

    // 打印
    flatMapRDD.collect().foreach(println)



  }
}
