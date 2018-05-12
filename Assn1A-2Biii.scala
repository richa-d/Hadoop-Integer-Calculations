val in=sc.textFile("/user/rsd352/intinput1.txt")
val in1=in.flatMap(line => line.split(" "))
val in2=in1.distinct
in2.saveAsTextFile("/user/rsd352/Ans1A-2Biii")