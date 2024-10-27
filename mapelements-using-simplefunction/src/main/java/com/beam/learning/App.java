package com.beam.learning;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.SimpleFunction;
import org.apache.beam.sdk.values.PCollection;

class User extends SimpleFunction<String, String> {
	
	@Override
	public String apply(String input) {
		
		String[] splitString = input.split(",");
		String output = "";
		if (splitString[2].equals("1"))
			output = splitString[0] + "," + splitString[1] + "," + "Female";
		else if (splitString[2].equals("2"))
			output = splitString[0] + "," + splitString[1] + "," + "Male";
		else
			output = splitString[0] + "," + splitString[1] + "," + splitString[2];
		return output;
	}
}

public class App {
    public static void main(String[] args) {
    	System.out.println("Example of Mapelements using SimpleFunction!!");
        
        Pipeline p = Pipeline.create();
        PCollection<String> pc = p.apply(TextIO.read().
        		from("D:\\Apachebeam\\mapelements-using-simplefunction\\file.csv"));
        PCollection<String> transformed = pc.apply(MapElements.via(new User()));
        transformed.apply(TextIO.write().to("D:\\Apachebeam\\mapelements-using-simplefunction\\output.csv")
        		.withNumShards(1).withSuffix(".csv"));
        p.run();
        
        System.out.println("See ya from Example of Mapelements using SimpleFunction!");
    }
}
