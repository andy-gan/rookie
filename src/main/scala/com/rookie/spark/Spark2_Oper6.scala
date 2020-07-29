package com.rookie.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * spark 算子练习
  */
// 需求：创建一个RDD, 过滤奇数
object Spark2_Oper6 {
  def main(args: Array[String]): Unit = {
    // 配置文件conf
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("makeRDD")
    // 上下文对象
    val sc: SparkContext = new SparkContext(sparkConf)

    // 创建
     val listRDD: RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6))
    // 分组
    val filterRDD: RDD[Int] = listRDD.filter(i => i%2==0)

    // 打印
    filterRDD.collect().foreach(println)



  }
}
