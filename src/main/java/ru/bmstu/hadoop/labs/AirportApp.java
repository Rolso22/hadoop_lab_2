package ru.bmstu.hadoop.labs;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;

public class AirportApp {
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("Usage: AirportApp <flight path> <airport path> <output path>");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(AirportApp.class);
        job.setJobName("JoinJob airport");
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, FlightsMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, AirportsMapper.class);
        FileOutputFormat.setOutputPath(job, new Path(args[2]));

        job.setPartitionerClass(AirportPartitioner.class);
        job.setGroupingComparatorClass(AirportComparator.class);
        job.setReducerClass(AirportReducer.class);
        job.setMapOutputKeyClass(AirportWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
