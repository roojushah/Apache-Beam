package com.beam.learning;

import org.apache.beam.sdk.options.PipelineOptions;

public interface MyOptions extends PipelineOptions{
	
	void setInputFile(String inputFile);
	String getInputFile();
	
	void setOutputFile(String outputFile);
	String getOutputFile();
	
	void setExtn(String extn);
	String getExtn();
}
