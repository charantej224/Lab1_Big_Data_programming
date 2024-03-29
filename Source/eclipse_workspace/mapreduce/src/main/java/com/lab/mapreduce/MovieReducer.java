package com.lab.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
/**
 * 
 * @author Charan
 * Most uplaoded category for the reducer
 */
public class MovieReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	public void reduce(Text word, Iterable<IntWritable> values, Context con)
			throws IOException, InterruptedException {
		int count = 0;
		for (IntWritable each : values) {
			count += each.get();
		}
		con.write(word, new IntWritable(count));
	}
}
