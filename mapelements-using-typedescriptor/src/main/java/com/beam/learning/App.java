package com.beam.learning;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.TypeDescriptors;

public class App {
    public static void main(String[] args) {
        System.out.println("Example of Mapelements!");
        
        Pipeline p = Pipeline.create();
        PCollection<String> pc = p.apply(TextIO.read().
        		from("D:\\Apachebeam\\mapelements-using-typedescriptor\\file.csv"));
        PCollection<String> transformed = pc.apply(MapElements.into(
        		TypeDescriptors.strings()).via((String s) -> s.toUpperCase()));
        transformed.apply(TextIO.write().to("D:\\Apachebeam\\mapelements-using-typedescriptor\\output.csv")
        		.withNumShards(1).withSuffix(".csv"));
        p.run();
        
        System.out.println("See ya from Example of Mapelements!");
    }
}