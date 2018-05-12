val in=sc.textFile("/user/rsd352/intinput1.txt")
val in1=in.flatMap(line => line.split(" "))
val in2=in1.distinct
val count=in2.count
sc.parallelize(Seq(count)).saveAsTextFile("/user/rsd352/Ans1A-2Biv")
