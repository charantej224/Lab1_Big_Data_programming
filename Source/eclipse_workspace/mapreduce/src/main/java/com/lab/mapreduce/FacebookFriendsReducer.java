package com.lab.mapreduce;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/***
 * 
 * @author Charan
 * Reducer Method to reduce to the relationships given
 *
 */

public class FacebookFriendsReducer extends Reducer<Text, Text, Text, Text> {

	@Override
	public void reduce(Text inputKey, Iterable<Text> inputValues,
			Context context) throws IOException, InterruptedException {
		String outputKey = inputKey.toString();
		String outputValue = " -> ( ";
		Set<String> tokenSet = new HashSet<>();
		for (Text eachValue : inputValues) {
			System.out.println(eachValue.toString());
			for (String token : eachValue.toString().split(("\\s+"))) {
				System.out.println(token);
				if (tokenSet.contains(token)) {
					outputValue += token + " ";
				}
				// Set cannot have duplicate values, so its okay to add all
				// values. same values will be overwritten
				tokenSet.add(token);
			}
		}
		outputValue += ")";
		outputKey = "( " + outputKey + " )";
		context.write(new Text(outputKey), new Text(outputValue));
		System.out.println(outputKey + outputValue);

	}

}
