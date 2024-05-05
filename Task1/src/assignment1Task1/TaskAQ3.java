package assignment1Task1;

import java.io.IOException;

import ca.pfv.spmf.algorithms.frequentpatterns.fpgrowth.AlgoFPMax;
import ca.pfv.spmf.tools.dataset_converter.TransactionDatabaseConverter;
import ca.pfv.spmf.tools.resultConverter.ResultConverter;

public class TaskAQ3 {	
	
	public void doMaxFp(String inputFile, String output_path, double minsup) throws IOException {
	//This method is for the doMaxFp algo, it is passed an input file, output file and the minimum support
	//it returns a text file of the most frequent patterns which will be analysed to find the top 5 most frequent patterns
	//Declare a location for the converted file to be stored
	String input_converted = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/bank_converted.txt";
	
	//Create an object of TransactionDatabaseConverter
	TransactionDatabaseConverter converter = new TransactionDatabaseConverter();
	// Convert the ARFF file to text file
	converter.convertARFFandReturnMap(inputFile, input_converted, Integer.MAX_VALUE);
	//Create an object for the top K mining algorithm
	// Specify output path along with the final output path
	String output = output_path + "Q3_fpMax.txt";
	String final_output = output_path + "Q3_final_fpMax.txt";
		
	try {
		// create an object of AlgoFPMax
		AlgoFPMax algo_FpMax = new AlgoFPMax();
			
		algo_FpMax.runAlgorithm(input_converted, output, minsup);
		algo_FpMax.printStats();
			
		//Convert outputs to include item names
		convert_output(input_converted, output, final_output);
			
	} catch (IOException e) {
		e.printStackTrace();
	}
}

public void convert_output(String input_dataset, String output, String final_output) {
		//This method was used to convert the files back from encoded to the original labeling
	try {
		//Convert outputs to include item names
		ResultConverter output_converter = new ResultConverter();
		output_converter.convert(input_dataset, output, final_output, null);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
	

	public static void main(String[] args) throws IOException {
		
		//Create an object for the TaskOneB class
		TaskAQ3 patternMining = new TaskAQ3();
		//the doMaxFp algo was run at min support of 0.2 for both data sets
		System.out.println(" ");
		System.out.println("Question 3");
		System.out.println("the doMaxFP algorithim is ran to find the top 5 most frequent maximum paterns for the no-class dataset as 0.2 support");
		String output_bankNoMax= "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/doMaxFPNoClassMax.txt";
		String input_bankNo = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/bank_no.arff";
		patternMining.doMaxFp(input_bankNo, output_bankNoMax, 0.2);
		
		System.out.println(" ");
		System.out.println("the doMaxFP algorithim is ran to find the top 5 most frequent maximum paterns for the yes-class dataset as 0.2 support");
		String input_bankYes = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/bank_yes.arff";
		String output_bankYesMax = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/doMaxFPYesClassMax.txt";
		patternMining.doMaxFp(input_bankYes, output_bankYesMax, 0.2);
		
	}

}
