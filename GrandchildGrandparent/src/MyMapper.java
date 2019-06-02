import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class MyMapper extends Mapper<Object, Text, Text, Text> {

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        // Remove spaces in input
        String valueStr = value.toString();
        valueStr = valueStr.replaceAll(" ", "");
        StringTokenizer itr = new StringTokenizer(valueStr);
        while (itr.hasMoreTokens()) {
            String tmp = itr.nextToken();
            String[] t = tmp.split(",");
            // Key: value = child: -parent
            context.write(new Text(t[0]), new Text("-" + t[1]));
            // Key: value = parent: +child
            context.write(new Text(t[1]), new Text("+" + t[0]));
        }
    }
}
