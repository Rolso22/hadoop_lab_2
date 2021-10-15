package ru.bmstu.hadoop.labs;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import static ru.bmstu.hadoop.labs.Constants.*;

public class AirportPartitioner extends Partitioner<AirportComparable, Text> {

    @Override
    public int getPartition(AirportComparable airportComparable, Text text, int numTasks) {
        return airportComparable.getAirportId() %  
    }
}
