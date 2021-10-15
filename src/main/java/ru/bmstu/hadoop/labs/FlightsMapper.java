package ru.bmstu.hadoop.labs;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

import static ru.bmstu.hadoop.labs.Constants.*;

public class FlightsMapper extends Mapper<LongWritable, Text, AirportComparable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException,
            InterruptedException {
        String[] columns = value.toString().split(",");
        if (key.get() > 0) {
            String delayTime = columns[DELAY_TIME_INDEX];
            if (delayTime.equals("")) {
                return;
            }
            int airportId = Integer.parseInt(columns[AIRPORT_INDEX]);
            context.write(new AirportComparable(airportId, FLIGHT_FLAG), new Text(delayTime));
        }
    }
}