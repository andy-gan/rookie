package com.rookie.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * spark 算子练习
  */
// 需求：创建一个RDD,按照元素%2的值进行分组
object Spark2_Oper5 {
  def main(args: Array[String]): Unit = {
    // 配置文件conf
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("makeRDD")
    // 上下文对象
    val sc: SparkContext = new SparkContext(sparkConf)

    // 创建
     val listRDD: RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6))
    // 分组
    val groupByRDD: RDD[(Int, Iterable[Int])] = listRDD.groupBy(i => i%2)

    // 打印
    groupByRDD.collect().foreach(println)



  }
}
