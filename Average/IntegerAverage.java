
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;

public class IntegerAverage extends Configured implements Tool {

    public int run(String[] args) throws Exception {
        //creating a JobConf object and assigning a job name for identification purposes
        JobConf conf = new JobConf(getConf(), IntegerAverage.class);
        conf.setJobName("IntegerAverage");

        conf.setMapOutputKeyClass(IntWritable.class);
        conf.setMapOutputValueClass(IntWritable.class);

        //Setting configuration object with the Data Type of output Key and Value
        conf.setOutputKeyClass(DoubleWritable.class);
        conf.setOutputValueClass(NullWritable.class);

        //Providing the mapper and reducer class names
        conf.setMapperClass(IntegerAverageMapper.class);
        conf.setReducerClass(IntegerAverageReducer.class);

        //the hdfs input and output directory to be fetched from the command line
        FileInputFormat.addInputPath(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));

        JobClient.runJob(conf);
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new IntegerAverage(), args);
        System.exit(res);
    }
}
