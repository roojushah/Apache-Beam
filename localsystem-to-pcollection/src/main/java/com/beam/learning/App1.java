package com.beam.learning;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.io.TextIO;

/**
 * Hello world!
 */
public class App1 {
    public static void main(String[] args) {
        System.out.println("Pcollection demo from Local file system!");
        
        Pipeline pipeline = Pipeline.create();
        PCollection<String> collection = pipeline.apply(TextIO.read().from("D:\\Apachebeam\\localsystem-to-pcollection\\file.csv"));
        collection.apply(TextIO.write().to("D:\\Apachebeam\\localsystem-to-pcollection\\output.csv").withNumShards(1).withSuffix(".csv"));
        pipeline.run();
        System.out.println("Ends :: Pcollection demo from Local system!");
    }
}
