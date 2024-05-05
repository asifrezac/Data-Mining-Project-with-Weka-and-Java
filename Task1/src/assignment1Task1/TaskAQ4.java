package assignment1Task1;
import java.io.IOException;
import ca.pfv.spmf.input.transaction_database_list_integers.TransactionDatabase;
import ca.pfv.spmf.tools.dataset_converter.TransactionDatabaseConverter;
import ca.pfv.spmf.tools.resultConverter.ResultConverter;
import ca.pfv.spmf.algorithms.frequentpatterns.fpgrowth.AlgoFPClose;
import ca.pfv.spmf.algorithms.frequentpatterns.apriori_close.AlgoAprioriClose;
import ca.pfv.spmf.algorithms.frequentpatterns.charm.AlgoCharm_Bitset;


public class TaskAQ4 {
	public void aprioriClose(String input_dataset, String output_path, double minsup) throws IOException {
		//Declare the converted file path
		String input_converted = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/bank_converted.txt";
		
		//Create an object of TransactionDatabaseConverter called converter
		TransactionDatabaseConverter converter = new TransactionDatabaseConverter();
		// Convert the ARFF file to text file
		converter.convertARFFandReturnMap(input_dataset, input_converted, Integer.MAX_VALUE);
		//Create an object for the top K mining algorithm
		// Specify output files		
		String output = output_path + "aorioriCloseQ3" + "MinSup" + minsup;
		String final_output = output_path + "Fiinal_aprioriCLoseQ3";
		

		try {
			AlgoAprioriClose algo_AprioriClose = new AlgoAprioriClose();
			
			algo_AprioriClose.runAlgorithm(minsup, input_converted, output);
			algo_AprioriClose.printStats();
			
			convert_output(input_converted, output, final_output);
			
		} catch (IOException e) {
			e.printStackTrace();
		}


		
	}

	public void FCPGrowthClosed(String input_dataset, String output_path, double minsup) throws IOException {
		//Declare the converted file path
		String input_converted = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/bank_converted.txt";
		
		//Create an object of TransactionDatabaseConverter called converter
		TransactionDatabaseConverter converter = new TransactionDatabaseConverter();
		// Convert the ARFF file to text file
		converter.convertARFFandReturnMap(input_dataset, input_converted, Integer.MAX_VALUE);
		// Specify output and final output path and append the name of the file
		
		String output = output_path + "Q3_fcp_Fpt.txt";
		String final_output = output_path + "Q3_final_fcp_Fpt.txt";
		//Enclised in the try/catch clause is the decleration of the FCP Growth algo object 
		//the algoritim is run by passing the input converted file, the output path and the min support
		try {
			AlgoFPClose algo_FCP_Growth = new AlgoFPClose(); 
			algo_FCP_Growth.runAlgorithm(input_converted, output, minsup);
			algo_FCP_Growth.printStats();
			
			//Convert outputs to include item names
			convert_output(input_converted, output, final_output);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void charmClosed(String input_dataset, String output_path, double minsup) throws IOException {
		
		String input_converted = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/bank_converted.txt";
		
		//Create an object of TransactionDatabaseConverter
		TransactionDatabaseConverter converter = new TransactionDatabaseConverter();
		// Convert the ARFF file to text file
		converter.convertARFFandReturnMap(input_dataset, input_converted, Integer.MAX_VALUE);
		// Specify output and final output path and append the name of the file
		
		String output = output_path + "Q3_fcp_Charm.txt";
		String final_output = output_path + "Q3_final_fcp_Charm.txt";
		//Enclised in the try/catch clause is the deceleration of the CHARM algo object 
		//the algoritim is run by passing the input converted file, the output path and the min support
				try {
			AlgoCharm_Bitset algo_FCP_Charm = new AlgoCharm_Bitset();
			
			//the charm algo requires a transaction database sp a transaction database object is declared and the input converted file is loaded to the tdb object and passed as the data set in the charm algo
			TransactionDatabase tdb = new TransactionDatabase(); 
			tdb.loadFile(input_converted);
			
			algo_FCP_Charm.runAlgorithm(output, tdb, minsup, false, 10000);
			algo_FCP_Charm.printStats();
			
			convert_output(input_converted, output, final_output);
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public void convert_output(String input_dataset, String output, String final_output) {
		//This method was used to convert the files back from encoded to the original labeling
		try {
			//Convert outputs to include item labels that where originally used
			ResultConverter output_converter = new ResultConverter();
			output_converter.convert(input_dataset, output, final_output, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	public static void main(String[] args) throws IOException {
		//Specify where to get the input file
		String input_file = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/bank.arff";  
		//Create an object for the TaskAQ4 class
		TaskAQ4 patternMining = new TaskAQ4();	
		// all three algos are run at min support of 0.2, 0.3, 0.4
		System.out.println("");
		System.out.println("Question 4");
		System.out.println("Generating frequent closed patterns from the entire dataset at a minimum support of 0.2, 0.3 and 0.4");
		System.out.println("");
		String closeOutput = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/";
		System.out.println("Apriori frequent closed set algorithim");
		System.out.println("");
		System.out.println("Min Support at 0.2");
		System.out.println("");
		patternMining.aprioriClose(input_file, closeOutput, 0.2);
		System.out.println("");
		System.out.println("Min Support at 0.3");
		System.out.println("");
		patternMining.aprioriClose(input_file, closeOutput, 0.3);
		System.out.println("");
		System.out.println("Min support at 0.4");
		System.out.println("");
		patternMining.aprioriClose(input_file, closeOutput, 0.4);
		System.out.println("");
		System.out.println("FCPGrowth frequent closed set algorithim");
		System.out.println("");
		System.out.println("Min Support at 0.2");
		System.out.println("");
		patternMining.FCPGrowthClosed(input_file, closeOutput, 0.2);
		System.out.println("");
		System.out.println("Min Support at 0.3");
		System.out.println("");
		patternMining.FCPGrowthClosed(input_file, closeOutput, 0.3);
		System.out.println("");
		System.out.println("Min support at 0.4");
		System.out.println("");
		patternMining.FCPGrowthClosed(input_file, closeOutput, 0.4);
		System.out.println("");
		System.out.println("Charm frequent closed set algorithim");
		System.out.println("");
		System.out.println("Min Support at 0.2");
		System.out.println("");
		patternMining.charmClosed(input_file, closeOutput, 0.2);
		System.out.println("");
		System.out.println("Min Support at 0.3");
		System.out.println("");
		patternMining.charmClosed(input_file, closeOutput, 0.3);
		System.out.println("");
		System.out.println("Min support at 0.4");
		System.out.println("");
		patternMining.charmClosed(input_file, closeOutput, 0.4);


	}

}
