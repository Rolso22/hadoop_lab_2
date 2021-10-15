package ru.bmstu.hadoop.labs;

import org.apache.hadoop.mapreduce.Reducer;

import javax.xml.soap.Text;

import java.util.Iterator;

import static ru.bmstu.hadoop.labs.Constants.*;

public class AirportReducer extends Reducer<AirportComparable, > {
    @Override
    protected void reduce(AirportComparable key, Iterator<Text> values, Context context) {

    }
}
