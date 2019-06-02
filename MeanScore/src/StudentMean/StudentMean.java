package StudentMean;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.io.IOException;

public class StudentMean {

    public static void main(String[] args) {
        // Default configuration
        Configuration config = new Configuration();

        try {
            // Get input and output path
            String[] otherArgs = new GenericOptionsParser(config, args).getRemainingArgs();
            if(otherArgs.length < 2) {
                System.err.println("Usage: StudentMean <in> [<in>...] <out>");
                System.exit(2);
            }

            // Create job
            Job job = Job.getInstance(config, "student mean");

            // Set jar package by class name
            job.setJarByClass(StudentMean.class);
            // Set mapper
            job.setMapperClass(MyMapper.class);
            // Set reducer
            job.setReducerClass(MyReducer.class);

            // Set class of output's key
            job.setOutputKeyClass(Text.class);
            // Set class of output's value
            job.setOutputValueClass(DoubleWritable.class);

            // Set input file path
            for(int i = 0; i < otherArgs.length - 1; i++) {
                FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
            }

            // Set output file path
            FileOutputFormat.setOutputPath(job, new Path(otherArgs[otherArgs.length - 1]));

            // Run and exit
            System.exit(job.waitForCompletion(true) ? 0 : 1);
        } catch (IOException e) {
            System.out.println("IO: ");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Interrupted: ");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found: ");
            e.printStackTrace();
        }
    }
}

