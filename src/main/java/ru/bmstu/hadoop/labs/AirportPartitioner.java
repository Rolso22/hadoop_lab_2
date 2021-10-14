package ru.bmstu.hadoop.labs;

import org.apache.hadoop.mapreduce.Partitioner;

import static ru.bmstu.hadoop.labs.Constants.*;

public class AirportPartitioner extends Partitioner {

    @Override
    public int getPartition(Object o, Object o2, int i) {
        return 0;
    }
}
