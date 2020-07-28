package com.rookie.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * spark wordCount
  */
object WordCount {
  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("wordCount")
    // 创建上下文对象
    val sc: SparkContext = new SparkContext(sparkConf)

    // 读取文件
    val lines: RDD[String] = sc.textFile("data/in")

    // 数据扁平化，拆分为单个单词
    val wordToOne: RDD[String] = lines.flatMap(_.split(" "))

    // 计数，返回 kv tuple
    val wordToTuple: RDD[(String, Int)] = wordToOne.map((_,1))

    // 分组计算
    val count: RDD[(String, Int)] = wordToTuple.reduceByKey(_+_)

    // 执行
    val result: Array[(String, Int)] = count.collect()

    // 打印
    result.foreach(println)

  }
}
