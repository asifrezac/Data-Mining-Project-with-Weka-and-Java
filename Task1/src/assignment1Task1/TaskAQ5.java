package assignment1Task1;
import java.io.IOException;
import ca.pfv.spmf.algorithms.associationrules.TopKRules_and_TNR.AlgoTopKClassRules;
import ca.pfv.spmf.algorithms.associationrules.TopKRules_and_TNR.Database;
import ca.pfv.spmf.tools.dataset_converter.TransactionDatabaseConverter;
import ca.pfv.spmf.tools.resultConverter.ResultConverter;

public class TaskAQ5 {
	
	public void topK_Consequent(String input_dataset, String output_path, double minconf, int top_k, int[] itemToBeUsedAsConsequent) throws IOException {
		// Declare the location for the converted text doc
		String input_converted = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/bank_converted.txt";
		//Create an object of TransactionDatabaseConverter
		TransactionDatabaseConverter converter = new TransactionDatabaseConverter();
		// use the converter object to convert the arff file to a text file and also changes from string values to intergers
		converter.convertARFFandReturnMap(input_dataset, input_converted, Integer.MAX_VALUE);

		//Specify output file and file output file path
		String output = output_path + "Q6out.txt";
		String final_output = output_path + "Q6outFINAL.txt";
		
		// the input data set is converted to a database
		Database db = new Database(); 
		try {
			db.loadFile(input_converted);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// an object is created for the topK_classRules algorithm 
		AlgoTopKClassRules topK_classRules = new AlgoTopKClassRules(); 
		
		// Generate association rules passing the top_k value, the minimum confidence, the database and the item to be used as a consequent 
		// Algorithim stats are printed along with the results been written to the output file 
		topK_classRules.runAlgorithm(top_k, minconf, db, itemToBeUsedAsConsequent);
		topK_classRules.printStats();
		try {
			topK_classRules.writeResultTofile(output);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Output file is converted back to have original string labeling
		ResultConverter output_converter = new ResultConverter();
		try {
			output_converter.convert(input_converted, output, final_output, null);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	

	public static void main(String[] args) throws IOException {
		//Specify input dataset
		String input_dataset = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/bank.arff";
		//Specify output files
		String output_path = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/SubNo";
		
		// Specify minimum confidence
		double minconf = 0.3;
		// Top-k was set to 10 as per question required
		int top_k = 10;
		// 11 is the encoding for subscribed=yes
		int[] itemToBeUsedAsConsequent = new int[] {11};
		
		TaskAQ5 generateRules = new TaskAQ5();
		System.out.println(" ");
		System.out.println("Question 5");
		System.out.println("this is the top 10 rules useing the consequent subscribe=no ");
		generateRules.topK_Consequent(input_dataset, output_path, minconf, top_k, itemToBeUsedAsConsequent);
		
		String output_path2 = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/SubYes";

		//42 is the encoding for the consequent 42
		int[] itemToBeUsedAsConsequent2 = new int[] {42};
		System.out.println(" ");
		System.out.println("this is the top 10 rules useing the consequent subscribe=yes ");
		generateRules.topK_Consequent(input_dataset, output_path2, minconf, top_k, itemToBeUsedAsConsequent2);

	}

}
