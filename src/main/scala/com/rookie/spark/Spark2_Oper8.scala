package com.rookie.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * spark 算子练习
  * distinct([numTasks]) 去重
  * 需求 创建一个RDD distinct去重
  */
// 需求：创建一个RDD, 过滤奇数
object Spark2_Oper8 {
  def main(args: Array[String]): Unit = {
    // 配置文件conf
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("makeRDD")
    // 上下文对象
    val sc: SparkContext = new SparkContext(sparkConf)

    // 创建
     val listRDD: RDD[Int] = sc.makeRDD(List(1,3,2,4,1,7,6,7,3,9))

    // 去重
    // val disRDD: RDD[Int] = listRDD.distinct()
    // 去重并自定义分区数 重新分区
    val disRDD: RDD[Int] = listRDD.distinct(2)
    // 打印
    disRDD.foreach(println)

    disRDD.saveAsTextFile("data/output")






  }
}
