package com.lab.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * 
 * @author Charan 
 * Use the reducer to reduce the map and writes it out as a file,
 *         further using HDFS commands we can get the values.
 *
 */
public class RatedReducer extends
		Reducer<Text, FloatWritable, Text, FloatWritable> {
	
	@Override
	public void reduce(Text input, Iterable<FloatWritable> values,
			Context context) throws IOException, InterruptedException{
		float totalRating = 0.0f;
		int repetetions = 0;
		for(FloatWritable rating : values){
			repetetions += 1;
			totalRating += rating.get();
		}
		if(repetetions > 1)
			totalRating = totalRating/repetetions;
		
		context.write(input, new FloatWritable(totalRating));
	}
	

}
