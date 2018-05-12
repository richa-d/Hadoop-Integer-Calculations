
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class DistinctReducer extends MapReduceBase implements Reducer<IntWritable, IntWritable, IntWritable, NullWritable> {

    public void reduce(IntWritable key, Iterator<IntWritable> values, OutputCollector<IntWritable, NullWritable> output, Reporter reporter) throws IOException {
        
        output.collect(key, NullWritable.get());

    }
}
