package StudentMean;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class MyMapper extends Mapper<Object, Text, Text, DoubleWritable> {

    private DoubleWritable score = new DoubleWritable();
    private Text student = new Text();

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        StringTokenizer itr = new StringTokenizer(value.toString());
        while (itr.hasMoreTokens()) {
            // Get a string of one line in input file
            String line = itr.nextToken();
            // Split line to items
            String[] items = line.split(",");
            // If current line is a elective Courses, skip it
            if(items[3].equals("选修")){
                continue;
            }
            // Key = class + name
            String tmpKey = items[0] + "," + items[1];
            student.set(tmpKey);
            // Value = score
            double sc = Double.parseDouble(items[4]);
            score.set(sc);
            context.write(student, score);
        }
    }
}
