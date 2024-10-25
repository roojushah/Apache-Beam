package com.beam.learning;

import org.apache.beam.sdk.Pipeline;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	System.out.println( "Hello World! From Main method" );
        Pipeline pipeline = Pipeline.create();
        System.out.println( "Hello World! End of Main method" );
    }
}
