import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class DistinctCountMapper extends MapReduceBase implements Mapper<LongWritable, Text, IntWritable, IntWritable> {
    //hadoop supported data types

    int v = 0;

    //map method that performs the tokenizer job and framing the initial key value pairs
    @Override
    public void map(LongWritable key, Text value, OutputCollector<IntWritable, IntWritable> output, Reporter reporter) throws IOException {
        //taking one line at a time and tokenizing the same
        String line = value.toString();
        StringTokenizer tokenizer = new StringTokenizer(line);

        //iterating through all the words available in that line and forming the key value pair
        while (tokenizer.hasMoreTokens()) {
            //word.set(tokenizer.nextToken());
            v = new Integer(tokenizer.nextToken());
            //sending to output collector which inturn passes the same to reducer
            output.collect(new IntWritable(v), new IntWritable(v));
        }
    }
}
