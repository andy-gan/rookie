package com.rookie.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * spark 算子练习
  * coalesce(numPartitions) 减少分区数
  * 需求：创建一个四个分区的RDD，对其缩减分区
  */
// 需求：创建一个RDD, 过滤奇数
object Spark2_Oper9 {
  def main(args: Array[String]): Unit = {
    // 配置文件conf
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("makeRDD")
    // 上下文对象
    val sc: SparkContext = new SparkContext(sparkConf)

    // 创建
     val listRDD: RDD[Int] = sc.makeRDD(List(1,3,2,4,1,7,6,7,3,9),8)
    // 初始分区
    println("初始分区个数：" + listRDD.partitions.size)
    // 缩减分区 其实本质是合并分区没有做suffer操作
    val coaRDD: RDD[Int] = listRDD.coalesce(4)
    // 缩减后
    println("缩减后分区个数：" + coaRDD.partitions.size)

  }
}
