val in=sc.textFile("/user/rsd352/intinput1.txt")
val in1=in.flatMap(line => line.split(" "))
val in2=in1.map({case (i) => (1,i)})
val count=in2.count
val in3=in2.map(a => (a._1,a._2.toInt))
val in4=in3.reduceByKey(_+_)
val in5=in4.map({case (i,j) => (j.toDouble/count)})
in5.saveAsTextFile("/user/rsd352/Ans1A-2Bii"))