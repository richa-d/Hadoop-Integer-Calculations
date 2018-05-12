
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class DistinctCountMapper2 extends MapReduceBase implements Mapper<Object, Text, IntWritable, IntWritable> {

    //map method that performs the tokenizer job and framing the initial key value pairs
    @Override
    public void map(Object key, Text value, OutputCollector<IntWritable, IntWritable> output, Reporter reporter) throws IOException {
        String line = value.toString();
        StringTokenizer tokenizer = new StringTokenizer(line);
        int v = 0;
        while (tokenizer.hasMoreTokens()) {
            v = new Integer(tokenizer.nextToken());
            v = new Integer(tokenizer.nextToken());
            output.collect(new IntWritable(1), new IntWritable(v));
        }

    }
}
