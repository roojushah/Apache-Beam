package com.beam.learning;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.Flatten;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PCollectionList;

public class App {
    public static void main(String[] args) {
    	System.out.println("Flatten example!!");
        
        Pipeline p = Pipeline.create();
        PCollection<String> pc1 = p.apply(TextIO.read().
        		from("D:\\Apachebeam\\flatten-example\\1.csv"));
        PCollection<String> pc2 = p.apply(TextIO.read().
        		from("D:\\Apachebeam\\flatten-example\\2.csv"));
        PCollection<String> pc3 = p.apply(TextIO.read().
        		from("D:\\Apachebeam\\flatten-example\\3.csv"));
        
        PCollectionList<String> list = PCollectionList.of(pc1).and(pc2).and(pc3);
        PCollection<String> transformed = list.apply(Flatten.pCollections());
        
        transformed.apply(TextIO.write().to("D:\\Apachebeam\\flatten-example\\output.csv")
        		.withNumShards(1).withSuffix(".csv").withHeader("Name,Age,Gender,City"));
        p.run();
        
        System.out.println("See ya from Flatten example!");
    }
}
