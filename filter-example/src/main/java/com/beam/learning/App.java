package com.beam.learning;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.Filter;
import org.apache.beam.sdk.transforms.SerializableFunction;
import org.apache.beam.sdk.values.PCollection;

class MyFilter implements SerializableFunction<String, Boolean> {

	@Override
	public Boolean apply(String input) {
		return input.contains("Ahmedabad");
	}
}

public class App {
    public static void main(String[] args) {
    	System.out.println("Filter example!!");
        
        Pipeline p = Pipeline.create();
        PCollection<String> pc = p.apply(TextIO.read().
        		from("D:\\Apachebeam\\filter-example\\file.csv"));
        PCollection<String> transformed = pc.apply(Filter.by(new MyFilter()));
        transformed.apply(TextIO.write().to("D:\\Apachebeam\\filter-example\\output.csv")
        		.withNumShards(1).withSuffix(".csv").withHeader("Name,Age,Gender,City"));
        p.run();
        
        System.out.println("See ya from Filter example!");
    }
}
