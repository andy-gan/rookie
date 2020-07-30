package com.rookie.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * spark 算子练习
  * sortBy 排序
  * sortBy(func,[ascending],[numTasks])
  */
// 需求：创建一个RDD, 过滤奇数
object Spark2_Oper11 {
  def main(args: Array[String]): Unit = {
    // 配置文件conf
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("makeRDD")
    // 上下文对象
    val sc: SparkContext = new SparkContext(sparkConf)

    // 创建
     val listRDD: RDD[Int] = sc.makeRDD(List(1,3,2,4,6,7,9))

    // 正序
    val aSortByRDD: RDD[Int] = listRDD.sortBy(x=>x)
    // 打印
    aSortByRDD.collect().foreach(print)

    // 倒序
    val dSortByRDD: RDD[Int] = listRDD.sortBy(x=>x,false)
    // 打印
    dSortByRDD.collect().foreach(print)



  }
}
