package FilteredClassifier;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Main {

	public static void main(String[] args) throws Exception {
		//Data source path is declared and getDataSet instance is also made into an object
		DataSource inputPath = new DataSource("/Users/brendanwallace-nash/Downloads/News(1).arff");
		Instances data = inputPath.getDataSet();
		
		//Class object is declared
		FilteredClassifiers textFilterClassifier = new FilteredClassifiers();
		
		
		System.out.println("");
		System.out.println("IBK Classifier");
		System.out.println("");
		//Start of algo runtime recorded 
		long startTime = System.currentTimeMillis();
		//Filtered Ibk ran on data
		textFilterClassifier.filteredIBKClassifier(data);
		//Time recorded at the end
		long stopTime = System.currentTimeMillis();		
		//Difference in time is recored for to a string to print
		String IBKTime=String.format("IBK Run Time in Milliseconds %d", stopTime - startTime);
		System.out.println(IBKTime);
		
		System.out.println("");
		System.out.println("SMO Classifier");
		System.out.println("");
		//Start of algo runtime recorded 
		long startTimeSMO = System.currentTimeMillis();
		//Filtered Ibk ran on data
		textFilterClassifier.filteredSMOClassifier(data);
		//Time recorded at the end
		long stopTimeSMO = System.currentTimeMillis();
		//Difference in time is recored for to a string to print
		String SMOTime=String.format("SMO Run Time in Milliseconds %d", stopTimeSMO - startTimeSMO);
		System.out.println(SMOTime);
		
		
		System.out.println("");
		System.out.println("J48 Classifier");
		System.out.println("");
		//Start of algo runtime recorded 
		long startTimeJ48 = System.currentTimeMillis();
		//Filtered Ibk ran on data
		textFilterClassifier.filteredJ48Classifier(data);
		//Time recorded at the end
		long stopTimeJ48 = System.currentTimeMillis();
		//Difference in time is recored for to a string to print
		String J48ime=String.format("J48 Run Time in Milliseconds %d", stopTimeJ48 - startTimeJ48);
		System.out.println(J48ime);
		
		System.out.println("");
		System.out.println("Hoeffding Tree Classifier");
		System.out.println("");
		//Start of algo runtime recorded 
		long startTimeHDT = System.currentTimeMillis();
		//Filtered Ibk ran on data
		textFilterClassifier.filteredHoeffdingClassifier(data);
		//Time recorded at the end
		long stopTimeHDT = System.currentTimeMillis();
		//Difference in time is recored for to a string to print
		String HDTime=String.format("Hoeffding Tree Run Time in Milliseconds %d", stopTimeHDT - startTimeHDT);
		System.out.println(HDTime);
		}
}

