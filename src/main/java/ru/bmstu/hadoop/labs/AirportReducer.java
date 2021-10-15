package ru.bmstu.hadoop.labs;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;
import java.util.Iterator;

import static ru.bmstu.hadoop.labs.Constants.*;

public class AirportReducer extends Reducer<AirportComparable, Text, Text, Text> {
    public AirportReducer() {
        super();
    }

    @Override
    protected void reduce(AirportComparable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        String airportName = values.next().toString();
        float max = Float.MIN_VALUE;
        float min = Float.MAX_VALUE;
        int count = 0;
        float sum = 0;
        if (!values.hasNext()) return;
        while (values.hasNext()) {
            float val = Float.parseFloat(values.next().toString());
            if (max < val) max = val;
            if (min > val) min = val;
            sum += val;
            count++;
        }
        context.write(new Text(airportName), new Text("min: " + min + "\n" + "max: " + max + "\n" + "average: " + sum/count));
    }

    @Override
    protected void reduce(AirportComparable key, Iterator<Text> values, Context context) throws IOException, InterruptedException {
        String airportName = values.next().toString();
        float max = Float.MIN_VALUE;
        float min = Float.MAX_VALUE;
        int count = 0;
        float sum = 0;
        if (!values.hasNext()) return;
        while (values.hasNext()) {
            float val = Float.parseFloat(values.next().toString());
            if (max < val) max = val;
            if (min > val) min = val;
            sum += val;
            count++;
        }
        context.write(new Text(airportName), new Text("min: " + min + "\n" + "max: " + max + "\n" + "average: " + sum/count));
    }
}
