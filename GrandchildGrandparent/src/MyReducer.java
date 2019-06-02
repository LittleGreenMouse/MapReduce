import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;

public class MyReducer extends Reducer<Text,Text,Text,Text> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        // List of current key's child
        ArrayList<Text> childOfKey = new ArrayList<>();
        // List of current key's parent
        ArrayList<Text> parentOfKey = new ArrayList<>();

        // According to prefix, divide values into child and parent
        for (Text value : values) {
            String name = value.toString();
            if(name.startsWith("+")){
                String n = name.substring(1);
                childOfKey.add(new Text(n));
            } else {
                String n = name.substring(1);
                parentOfKey.add(new Text(n));
            }
        }

        // Child and parent pairwise pairing
        for(Text child : childOfKey) {
            for(Text parent : parentOfKey) {
                context.write(child, parent);
            }
        }
    }
}
