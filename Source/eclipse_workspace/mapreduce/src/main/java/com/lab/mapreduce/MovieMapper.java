package com.lab.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
/**
 * 
 * @author Charan
 * Most uploaded category mapper
 *
 */
public class MovieMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String eachLine = value.toString();
		String[] stringTokens = eachLine.split("\t");
		Text outputKey = null;
		// if length is less than 5 the string extraction throws up.
		if (stringTokens.length > 5) {
			outputKey = new Text(stringTokens[3]);
			IntWritable outputValue = new IntWritable(1);
			context.write(outputKey, outputValue);
		}
	}
}
