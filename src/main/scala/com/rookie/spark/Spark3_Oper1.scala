package com.rookie.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * spark 算子练习

  */

object Spark3_Oper1 {
  def main(args: Array[String]): Unit = {
    // 配置文件conf
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("makeRDD")
    // 上下文对象
    val sc: SparkContext = new SparkContext(sparkConf)

    // 创建
    val listRDD1: RDD[Int] = sc.makeRDD(List(1,3,2))
    val listRDD2: RDD[Int] = sc.makeRDD(List(1,2,6,7,9))
    // 合并
    listRDD1.union(listRDD2).foreach(println)

    println("************")
    // 求差 rdd1 中有 rdd2中没有
    listRDD1.subtract(listRDD2).foreach(println)

    println("************")
    // 交集
    listRDD1.intersection(listRDD2).foreach(println)

    println("************")
    // 笛卡尔积
    listRDD1.cartesian(listRDD2).foreach(println)

    println("************")
    // 拉链
    val listRDD3: RDD[Int] = sc.makeRDD(List(1,3,2),3)
    val listRDD4: RDD[String] = sc.makeRDD(List("a","b","v"),3)
    listRDD3.zip(listRDD4).foreach(println)

  }
}
