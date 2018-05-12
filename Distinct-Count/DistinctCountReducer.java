
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class DistinctCountReducer extends MapReduceBase implements Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {

    @Override
    public void reduce(IntWritable key, Iterator<IntWritable> values, OutputCollector<IntWritable, IntWritable> output, Reporter reporter) throws IOException {

        output.collect(new IntWritable(1), key);

    }
}
