package com.beam.learning;

import java.util.ArrayList;
import java.util.List;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.TypeDescriptor;
import org.apache.beam.sdk.values.TypeDescriptors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World from Objects to PCollection!");
        
        Pipeline p = Pipeline.create();
        // This will have PCollection of Customer
        PCollection<Customer> pc = p.apply(Create.of(allCustomer()));
        // Now we need to convert Customer PC to String PC cz TextIO only support PC of String
        PCollection<String> pcs = pc.apply(MapElements.into(
        		TypeDescriptors.strings()).via((Customer c) -> c.getName()));
        pcs.apply(TextIO.write().to("D:\\Apachebeam\\objects-to-pcollection\\output.csv")
        		.withNumShards(1).withSuffix(".csv"));
        p.run();
        
        System.out.println("See ya from Objects to PCollection!");
    }
    
    static List<Customer> allCustomer() {
    	Customer c1 = new Customer("1", "Rooju");
    	Customer c2 = new Customer("2", "Ruju Shah");
    	
    	List<Customer> list = new ArrayList<Customer>();
    	list.add(c1);
    	list.add(c2);
    	
    	return list;
    	
    	
    }
}
