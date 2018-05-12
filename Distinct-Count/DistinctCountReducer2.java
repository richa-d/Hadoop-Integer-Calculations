
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class DistinctCountReducer2 extends MapReduceBase implements Reducer<IntWritable, IntWritable, IntWritable, NullWritable> {

    @Override
    public void reduce(IntWritable key, Iterator<IntWritable> values, OutputCollector<IntWritable, NullWritable> output, Reporter reporter) throws IOException {
        int count = 0;

        while (values.hasNext()) {
            int x = values.next().get();
            count++;
        }

        output.collect(new IntWritable(count), NullWritable.get());

    }
}
