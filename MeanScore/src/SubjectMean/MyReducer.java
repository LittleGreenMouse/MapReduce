package SubjectMean;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.text.DecimalFormat;

public class MyReducer extends Reducer<Text, DoubleWritable,Text,DoubleWritable> {

    private DoubleWritable result = new DoubleWritable();

    @Override
    protected void reduce(Text key, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {
        // Calculate mean of score
        double sum = 0;
        int num = 0;
        for (DoubleWritable val : values) {
            sum += val.get();
            num++;
        }
        double mean = sum / num;

        // Convert mean to two decimal places number
        DecimalFormat df = new DecimalFormat("#.##");
        mean = Double.parseDouble(df.format(mean));

        // Set result
        result.set(mean);
        context.write(key, result);
    }
}
