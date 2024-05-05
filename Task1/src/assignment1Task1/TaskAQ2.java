package assignment1Task1;
import java.io.FileNotFoundException;
import java.io.IOException;
import ca.pfv.spmf.algorithms.frequentpatterns.fpgrowth.AlgoFPGrowth;
import ca.pfv.spmf.tools.dataset_converter.TransactionDatabaseConverter;
import ca.pfv.spmf.tools.resultConverter.ResultConverter;

public class TaskAQ2 {
	
	public void FPGrowthAlgo(String inputFile, String outputFile, Double minSupport) throws FileNotFoundException, IOException {
		//This method takes the input path, output path and the min support of 
							
			//Declare the path for the converted bank document
			String input_converted = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/bank_converted.txt";
			
			
			//The following code was used to convert the text items to numbers, to allow for their use in the Apri and FP Growth
		
			try {
				//Create an object of TransactionDatabaseConverter
				TransactionDatabaseConverter converter = new TransactionDatabaseConverter();	
				// Convert the ARFF file to text file
				converter.convertARFFandReturnMap(inputFile, input_converted, Integer.MAX_VALUE);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//The location for the final output is declared
			String FinaloutputFile = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/Finalbank_converted.txt";
			// a new object is created for the FP Growth algorithm 
			AlgoFPGrowth algo_FPGrowth = new AlgoFPGrowth();
			//The minimum and maximum pattern length is set to three as we are only interested in patters of length three
			algo_FPGrowth.setMaximumPatternLength(3);
			
			algo_FPGrowth.setMinimumPatternLength(3);
			//the FP Growth algorithim is run with the converted file, the output for the final file and the min confidence parameter 			
			algo_FPGrowth.runAlgorithm(input_converted, FinaloutputFile, minSupport);
				
			// an output converter object is declared to convert the data set back to its labels instead of intriguer encoding
			ResultConverter output_converter = new ResultConverter();
			//Convert the output back to have the original text and not number encoding			
			output_converter.convert(input_converted, FinaloutputFile, outputFile, null);
			


		
	}
	

	public static void main(String[] args) throws FileNotFoundException, IOException {

		//Create an object for the TaskAQ2 class
		TaskAQ2 patternMining = new TaskAQ2();
		//The FP Growth algorithm is run at min support of 0.2 for both data sets
		System.out.println(" ");
		System.out.println("Question 2");
		System.out.println("FP Growth is ran at minimum support of 0.2 for bank_no, results can be seen in the FPGrowthNoClass.txt file");
		String input_bankYes = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/bank_yes.arff";
		String output_bankYes = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/FPGrowthYesClass.txt";
		patternMining.FPGrowthAlgo(input_bankYes,output_bankYes, 0.2 );
		
		System.out.println(" ");
		System.out.println("FP Growth is ran at minimum support of 0.2 for bank_no, results can be seen in the FPGrowthNoClass.txt file");
		String input_bankNo = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/bank_no.arff";
		String output_bankNo= "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/FPGrowthNoClass.txt";
		patternMining.FPGrowthAlgo(input_bankNo,output_bankNo, 0.2 );

	}

}
