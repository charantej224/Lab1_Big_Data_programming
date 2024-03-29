package com.lab.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * 
 * @author Charan
 * Facebook friends mapper to map the friends to another.
 *
 */
public class FacebookFriendsMapper extends
		Mapper<LongWritable, Text, Text, Text> {

	@Override
	public void map(LongWritable inputKey, Text inputValue, Context context)
			throws IOException, InterruptedException {

		String eachLine = inputValue.toString();
		String[] keyValueArray = eachLine.split("->");
		Text outputText;

		if (keyValueArray.length >= 2) {
			String key = keyValueArray[0].trim();
			keyValueArray[1] = keyValueArray[1].trim();
			Text outputValue = new Text(keyValueArray[1]);
			System.out.println("Key: " + key + " Value: " + keyValueArray[1]);
			
			for (String secondKey : keyValueArray[1].split("\\s+")) {
				if (key.compareToIgnoreCase(secondKey) < 0) {
					String outputKey = key + " " + secondKey;
					outputText = new Text(outputKey);
					context.write(outputText, outputValue);
				} else {
					String outputKey = secondKey + " " + key;
					outputText = new Text(outputKey);
					context.write(outputText, outputValue);
				}
				System.out.println(outputText.toString() + " ->  " + outputValue.toString());
			}

		}
	}
}