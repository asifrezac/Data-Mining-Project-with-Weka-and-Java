package assignment1Task1;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//Specify where to get the input file
		String input_file = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/bank.arff";  
		String input_bankYes = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/bank_yes.arff";
		String input_bankNo = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/bank_no.arff";
		
		//Task 1
		//Create an object for the TaskAQ1 class
		TaskAQ1 PMTask1 = new TaskAQ1();
		//The function for Apriori and FP Growth are run three times at three different min support levels
		System.out.println(" ");
		System.out.println("Question 1");
		System.out.println(" ");
		System.out.println("Apriori and FP Growth algorithims stats at minimum confidence of 0.2");
		PMTask1.FPG_aprori(input_file, 0.2);
		System.out.println(" ");
		System.out.println("Apriori and FP Growth algorithims stats at minimum confidence of 0.3");
		PMTask1.FPG_aprori(input_file, 0.3);
		System.out.println(" ");
		System.out.println("Apriori and FP Growth algorithims stats at minimum confidence of 0.4");
		PMTask1.FPG_aprori(input_file, 0.4);

		//Task 2
		//Create an object for the TaskAQ2 class
		TaskAQ2 PMTask2 = new TaskAQ2();
		//The FP Growth algorithm is run at min support of 0.2 for both data sets
		System.out.println(" ");
		System.out.println("Question 2");
		System.out.println("FP Growth is ran at minimum support of 0.2 for bank_no, results can be seen in the FPGrowthNoClass.txt file");
		String output_bankYes = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/FPGrowthYesClass.txt";
		PMTask2.FPGrowthAlgo(input_bankYes,output_bankYes, 0.2 );
		System.out.println(" ");
		System.out.println("FP Growth is ran at minimum support of 0.2 for bank_no, results can be seen in the FPGrowthNoClass.txt file");
		String output_bankNo= "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/FPGrowthNoClass.txt";
		PMTask2.FPGrowthAlgo(input_bankNo,output_bankNo, 0.2 );
		
		//Task 3
		//Create an object for the TaskOneB class
		TaskAQ3 PMTask3 = new TaskAQ3();
		//the doMaxFp algo was run at min support of 0.2 for both data sets
		System.out.println(" ");
		System.out.println("Question 3");
		System.out.println("the doMaxFP algorithim is ran to find the top 5 most frequent maximum paterns for the no-class dataset as 0.2 support");
		String output_bankNoMax= "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/doMaxFPNoClassMax.txt";
		PMTask3.doMaxFp(input_bankNo, output_bankNoMax, 0.2);
		System.out.println(" ");
		System.out.println("the doMaxFP algorithim is ran to find the top 5 most frequent maximum paterns for the yes-class dataset as 0.2 support");
		String output_bankYesMax = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/doMaxFPYesClassMax.txt";
		PMTask3.doMaxFp(input_bankYes, output_bankYesMax, 0.2);
		
		//Task 4
		//Specify where to get the input file
		//Create an object for the TaskAQ4 class
		TaskAQ4 PMTask4 = new TaskAQ4();	
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
		PMTask4.aprioriClose(input_file, closeOutput, 0.2);
		System.out.println("");
		System.out.println("Min Support at 0.3");
		System.out.println("");
		PMTask4.aprioriClose(input_file, closeOutput, 0.3);
		System.out.println("");
		System.out.println("Min support at 0.4");
		System.out.println("");
		PMTask4.aprioriClose(input_file, closeOutput, 0.4);
		System.out.println("");
		System.out.println("FCPGrowth frequent closed set algorithim");
		System.out.println("");
		System.out.println("Min Support at 0.2");
		System.out.println("");
		PMTask4.FCPGrowthClosed(input_file, closeOutput, 0.2);
		System.out.println("");
		System.out.println("Min Support at 0.3");
		System.out.println("");
		PMTask4.FCPGrowthClosed(input_file, closeOutput, 0.3);
		System.out.println("");
		System.out.println("Min support at 0.4");
		System.out.println("");
		PMTask4.FCPGrowthClosed(input_file, closeOutput, 0.4);
		System.out.println("");
		System.out.println("Charm frequent closed set algorithim");
		System.out.println("");
		System.out.println("Min Support at 0.2");
		System.out.println("");
		PMTask4.charmClosed(input_file, closeOutput, 0.2);
		System.out.println("");
		System.out.println("Min Support at 0.3");
		System.out.println("");
		PMTask4.charmClosed(input_file, closeOutput, 0.3);
		System.out.println("");
		System.out.println("Min support at 0.4");
		System.out.println("");
		PMTask4.charmClosed(input_file, closeOutput, 0.4);
		
		//Task 5
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
		generateRules.topK_Consequent(input_file, output_path, minconf, top_k, itemToBeUsedAsConsequent);
		
		String output_path2 = "/Users/brendanwallace-nash/Desktop/DataMiningAssignment/SubYes";

		//42 is the encoding for the consequent 42
		int[] itemToBeUsedAsConsequent2 = new int[] {42};
		System.out.println(" ");
		System.out.println("this is the top 10 rules useing the consequent subscribe=yes ");
		generateRules.topK_Consequent(input_file, output_path2, minconf, top_k, itemToBeUsedAsConsequent2);

		
	}

}
