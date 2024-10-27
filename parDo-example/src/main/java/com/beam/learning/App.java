package com.beam.learning;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

class User extends DoFn<String, String> {
	
	@ProcessElement
	public void processElement(ProcessContext context) {
		String input = context.element();
		String arr[] = input.split(",");
		if (arr[2].equals("1")) {
			context.output(input);
		}
	}
}

public class App {
    public static void main(String[] args) {
    	System.out.println("ParDo example!!");
        
        Pipeline p = Pipeline.create();
        PCollection<String> pc = p.apply(TextIO.read().
        		from("D:\\Apachebeam\\parDo-example\\file.csv"));
        PCollection<String> transformed = pc.apply(ParDo.of(new User()));
        transformed.apply(TextIO.write().to("D:\\Apachebeam\\parDo-example\\output.csv")
        		.withNumShards(1).withSuffix(".csv").withHeader("Name,Age,Gender"));
        p.run();
        
        System.out.println("See ya from ParDo example!");
    }
}
