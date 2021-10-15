package ru.bmstu.hadoop.labs;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;
import java.util.Iterator;

public class AirportReducer extends Reducer<AirportComparable, Text, Text, Text> {

    @Override
    protected void reduce(AirportComparable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> itr = values.iterator();
        String airportName = itr.next().toString();
/*        for (Text v : values) {
            System.out.println(v.toString());
        }*/
        float max = Float.MIN_VALUE;
        float min = Float.MAX_VALUE;
        int count = 0;
        float sum = 0.0f;
        if (!itr.hasNext()) return;
        while (itr.hasNext()) {
            float val = Float.parseFloat(itr.next().toString());
            if (max < val) max = val;
            if (min > val) min = val;
            sum += val;
            count++;
        }
        context.write(new Text(airportName), new Text("min: " + min + "\n" + "max: " + max + "\n" + "average: " + sum/count));
    }
}
