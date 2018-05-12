
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class IntCalcReducer extends MapReduceBase implements Reducer<IntWritable, IntWritable, IntWritable, NullWritable> {

    @Override
    public void reduce(IntWritable key, Iterator<IntWritable> values, OutputCollector<IntWritable, NullWritable> output, Reporter reporter) throws IOException {
        int max = 0;
        while (values.hasNext()) {
            int curr = values.next().get();
            if (curr > max) {
                max = curr;
            }
        }
        output.collect(new IntWritable(max), NullWritable.get());
    }
}
