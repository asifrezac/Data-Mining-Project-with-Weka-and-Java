package assignment1Task1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import ca.pfv.spmf.algorithms.frequentpatterns.apriori.AlgoApriori;
import ca.pfv.spmf.algorithms.frequentpatterns.fpgrowth.AlgoFPGrowth;
import ca.pfv.spmf.tools.dataset_converter.TransactionDatabaseConverter;
import ca.pfv.spmf.tools.resultConverter.ResultConverter;


public class TaskAQ1 {
		
	public void FPG_aprori(String input_dataset, Double minSupport) throws FileNotFoundException, IOException {
			
			//This function takes the path string of the datasets and the minimum support to perform both Apriori and FP Growth algorithims
			//Seeing that the output is not needed null is paced in place of a output path string
		
	
			String input_converted = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/bank_converted.txt";
			
			
			//The following code was used to convert the text items to numbers, to allow for their use in the Apri and FP Growth
		
			try {
				//Create an object of TransactionDatabaseConverter
				TransactionDatabaseConverter converter = new TransactionDatabaseConverter();	
				// Convert the ARFF file to text file
				converter.convertARFFandReturnMap(input_dataset, input_converted, Integer.MAX_VALUE);
			} catch (IOException e) {
				e.printStackTrace();
			}
	
			
			// Create objects of pattern mining algorithms for apriori and FP Growth
			AlgoApriori algo_Apri = new AlgoApriori();
			AlgoFPGrowth algo_FPGrowth = new AlgoFPGrowth();
			
			// The maximum number of patterns is set to 3
			algo_Apri.setMaximumPatternLength(3);
			algo_FPGrowth.setMaximumPatternLength(3);
				
			// Minimum number of patterns is set for FP Growth (it is not needed for others) 
			algo_FPGrowth.setMinimumPatternLength(1);
			
			//The algorithms are run and their stats are printed in the console, Apriori produces an output file
			algo_Apri.runAlgorithm(minSupport, input_converted, null); 
			algo_Apri.printStats();
						
			algo_FPGrowth.runAlgorithm(input_converted, null, minSupport);
			algo_FPGrowth.printStats();
		}
	
	public void FPGrowthAlgo(String inputFile, String outputFile, Double minConfidence) throws FileNotFoundException, IOException {
		//This function takes the path string of the datasets and the minimum support to perform both Apriori and FP Growth algorithims
				//Seeing that the output is not needed null is paced in place of a output path string
			
	
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
			
			String FinaloutputFile = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/Finalbank_converted.txt";
			
			AlgoFPGrowth algo_FPGrowth = new AlgoFPGrowth();
			
			algo_FPGrowth.setMaximumPatternLength(10);
			
			algo_FPGrowth.setMinimumPatternLength(3);
			
			algo_FPGrowth.runAlgorithm(input_converted, FinaloutputFile, minConfidence);
						
			//Convert the output back to have the original text and not number incoding
			ResultConverter output_converter = new ResultConverter();
			
			
			
			output_converter.convert(input_converted, FinaloutputFile, outputFile, null);
			
			// int counter=0;String str;
	
	
	        String line = null;
	
	            BufferedReader bufferedReader = 
	                new BufferedReader(new FileReader(outputFile));
	
	            int i = 0;
	            try {
	                //print first 5 lines or all if file has less than 5 lines
	                while(((line = bufferedReader.readLine()) != null) && i < 5) {
	                    System.out.println(line);
	                    i++;
	                }   
	            }
	            finally {   
	                bufferedReader.close();         
	            }
	}
	
		
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//Specify where to get the input file
		String input_file = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/bank.arff";  
		//Create an object for the TaskAQ1 class
		TaskAQ1 patternMining = new TaskAQ1();
		//The function for Apriori and FP Growth are run three times at three different min support levels
		System.out.println(" ");
		System.out.println("Question 1");
		System.out.println(" ");
		System.out.println("Apriori and FP Growth algorithims stats at minimum confidence of 0.2");
		patternMining.FPG_aprori(input_file, 0.2);
		System.out.println(" ");
		System.out.println("Apriori and FP Growth algorithims stats at minimum confidence of 0.3");
		patternMining.FPG_aprori(input_file, 0.3);
		System.out.println(" ");
		System.out.println("Apriori and FP Growth algorithims stats at minimum confidence of 0.4");
		patternMining.FPG_aprori(input_file, 0.4);

	}

}
