package Task2;

import java.util.Random;

import weka.attributeSelection.ASEvaluation;
import weka.attributeSelection.ASSearch;
import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
import weka.classifiers.AbstractClassifier;
import weka.classifiers.CostMatrix;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.Logistic;
import weka.classifiers.meta.AttributeSelectedClassifier;
import weka.classifiers.meta.CostSensitiveClassifier;
import weka.classifiers.rules.PART;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;


public class Task2 {
	
	public void CostSensitivity(Instances data, AbstractClassifier classifier, boolean newMinimizeExpectedCost, String classifierName) {
		try {
			//this is the cost sensitive matrix with importance put on false negatives
			String matlab = "[0.0 5.0; 1.0 0.0]"; //cost matrix
			CostMatrix matrix = CostMatrix.parseMatlab(matlab);
			
			//this is the cost sensitive classifier object
			CostSensitiveClassifier cosecl= new CostSensitiveClassifier();
			
			//setting up the parameters of the cost sensitive classifier object
			//which are the cost matrix, classifier and the boolean value of minimizeExpectedCost
			cosecl.setCostMatrix(matrix);
			cosecl.setClassifier(classifier);
			cosecl.setMinimizeExpectedCost(newMinimizeExpectedCost);
			
			//evaluation
			Evaluation eval = new Evaluation(data, matrix);
			eval.crossValidateModel(cosecl, data, 10, new Random(1));
			
			System.out.println(classifierName + " : "+ eval.correct()/eval.numInstances() + "    Total cost" + " : " + eval.totalCost());
		}
		catch (Exception e){
			 System.out.println("Error !!!");
			 e.printStackTrace();
		}
	}
	
	public void doFilteredClassification(Instances data, AbstractClassifier classifier, ASEvaluation evaluator, ASSearch searcher, String classifierName) {
		try {
			//this object will calculate the accuracy of the classifiers
			//taking the specific number of attributes into consideration.
			AttributeSelectedClassifier asc = new AttributeSelectedClassifier();
			
			//setting up the parameters
			asc.setClassifier(classifier);
			asc.setEvaluator(evaluator);
			asc.setSearch(searcher);
			
			//evaluation
			Evaluation eval = new Evaluation(data);
			eval.crossValidateModel(asc, data, 10, new Random(1));
			System.out.println(classifierName + " : " + eval.correct()/eval.numInstances());
		}
		catch(Exception e) {
			System.out.println("Error !!!");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataSource source;
		Task2 filters = new Task2();
		try {
			source = new DataSource("/Users/asifrezachowdhury/Library/CloudStorage/OneDrive-Personal/Academics/QUT Academics/Semester 2-1/IFN645/Assignments/Assignment02/COVID19_risk.arff");
			Instances data = source.getDataSet();
			data.setClass(data.attribute("infection_risk"));
			
			//importing classification algorithms
			NaiveBayes nb = new NaiveBayes();
			Logistic lg = new Logistic();
			PART prt = new PART();
			J48 jt = new J48();
			
			//setting number of attributes for the algorithms
			Ranker rankingNB = new Ranker();
			Ranker rankingLG = new Ranker();
			Ranker rankingPRT = new Ranker();
			Ranker rankingJT = new Ranker();
			rankingNB.setNumToSelect(3);
			rankingLG.setNumToSelect(6);
			rankingPRT.setNumToSelect(6);
			rankingJT.setNumToSelect(3);
			
			//apply the two functions written above for the respective tasks
			System.out.println("Accuracy of the classifiers with selected number of attributes");
			filters.doFilteredClassification(data, nb, new InfoGainAttributeEval(), rankingNB, "Naive Bayes");
			filters.doFilteredClassification(data, lg, new InfoGainAttributeEval(), rankingLG, "Logistic");
			filters.doFilteredClassification(data, prt, new InfoGainAttributeEval(), rankingPRT, "PART");
			filters.doFilteredClassification(data, jt, new InfoGainAttributeEval(), rankingJT, "J48");
			System.out.println();
			System.out.println("Accuracy and total cost of the classifier regarding the cost sensitive analysis");
			filters.CostSensitivity(data, lg, true, "Logistic (minimize Expected cost: True)");
			filters.CostSensitivity(data, lg, false, "Logistic (minimize Expected cost: False)");
			filters.CostSensitivity(data, jt, true, "J48 (minimize Expected cost: True)");
			filters.CostSensitivity(data, jt, false, "J48 (minimize Expected cost: False)");
			
		}
		catch (Exception e) {
			System.out.println("Error !!!");
			e.printStackTrace();
		}

	}

}
