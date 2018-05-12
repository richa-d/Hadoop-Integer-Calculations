
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class IntegerAverageReducer extends MapReduceBase implements Reducer<IntWritable, IntWritable, DoubleWritable, NullWritable> {

    @Override
    public void reduce(IntWritable key, Iterator<IntWritable> values, OutputCollector<DoubleWritable, NullWritable> output, Reporter reporter) throws IOException {
        double sum = 0, count = 0;
        while (values.hasNext()) {
            int curr = values.next().get();
            sum += (double) curr;
            count++;
        }
        output.collect(new DoubleWritable(sum / count), NullWritable.get());
    }
}
