package ru.bmstu.hadoop.labs;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

import static ru.bmstu.hadoop.labs.Constants.*;

public class AirportsMapper extends Mapper<LongWritable, Text, AirportComparable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException,
            InterruptedException {
        String[] columns = value.toString().split("\",\"");
        if (key.get() > 0) {
            int airportId = Integer.parseInt(columns[CODE_INDEX].replaceAll("\"", ""));
            String airportName = columns[DESCRIPTION_INDEX].replaceAll("\"", "");
            context.write(new AirportComparable(airportId, AIRPORT_FLAG), new Text(airportName));
        }
    }
}