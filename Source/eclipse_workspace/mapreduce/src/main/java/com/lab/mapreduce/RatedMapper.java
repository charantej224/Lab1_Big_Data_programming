package com.lab.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
/**
 * 
 * @author Charan
 * write out vedio name and the rating as output from the Mapper.
 *
 */

public class RatedMapper extends
		Mapper<LongWritable, Text, Text, FloatWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String eachLine = value.toString();
		String[] tokenArray = eachLine.split("\t");
		if (tokenArray.length >= 7) {
			if (null != tokenArray[0] && tokenArray[6].matches("\\d+.+")) {
				Text outputKey = new Text(tokenArray[0]);
				FloatWritable outputValue = new FloatWritable(
						Float.valueOf(tokenArray[6]));
				context.write(outputKey,outputValue);

			}
		}

	}
}
