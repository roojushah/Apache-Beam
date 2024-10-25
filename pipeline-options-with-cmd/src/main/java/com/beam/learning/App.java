package com.beam.learning;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.values.PCollection;

public class App {
    public static void main(String[] args) {
        System.out.println("From Pipeline options");
        
        MyOptions options = PipelineOptionsFactory.fromArgs(args).withValidation().as(MyOptions.class);
        Pipeline pipeline = Pipeline.create(options);
        PCollection<String> collection = pipeline.apply(TextIO.read().from(options.getInputFile()));
        collection.apply(TextIO.write().to(options.getOutputFile()).withNumShards(1).withSuffix(".csv"));
        pipeline.run();
        System.out.println("See ya from Objects to PCollection!");
    }
}
