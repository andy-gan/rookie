package com.rookie.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * spark 算子练习
  * sample(withReplacement,fraction,seed)  采样
  * 需求 创建一个RDD 从中不放回抽样
  */
// 需求：创建一个RDD, 过滤奇数
object Spark2_Oper7 {
  def main(args: Array[String]): Unit = {
    // 配置文件conf
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("makeRDD")
    // 上下文对象
    val sc: SparkContext = new SparkContext(sparkConf)

    // 创建
     val listRDD: RDD[Int] = sc.makeRDD(1 to 10)
    // 采样 不放回
    val sampleRDD: RDD[Int] = listRDD.sample(false,0.3,2)

    // 采样  放回
    val sampleRDD1: RDD[Int] = listRDD.sample(true,1,2)
    // 打印
    sampleRDD.foreach(println)
    sampleRDD1.foreach(println)




  }
}
