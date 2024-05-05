package FilteredClassifier;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.Instances;
import weka.core.SelectedTag;
import weka.core.stemmers.LovinsStemmer;
import weka.core.stopwords.Rainbow;
import weka.core.tokenizers.WordTokenizer;
import weka.filters.unsupervised.attribute.StringToWordVector;
import weka.classifiers.lazy.IBk;
import weka.classifiers.trees.HoeffdingTree;
import weka.classifiers.functions.SMO;
import weka.classifiers.trees.J48;

public class FilteredClassifiers {
	
	public void filteredHoeffdingClassifier(Instances data) throws Exception  {
		//index the data set
		data.setClassIndex(1);
		// declare a string to word vector filter
		StringToWordVector swFilter = new StringToWordVector();
		//set the range of attributes 
		swFilter.setAttributeIndices("first-last"); 
		//setting filter parameters to that of the weka filter
		swFilter.setIDFTransform(false);
		swFilter.setTFTransform(false);
		swFilter.setNormalizeDocLength(
		new SelectedTag(StringToWordVector.FILTER_NORMALIZE_ALL,
		StringToWordVector.TAGS_FILTER));
		swFilter.setMinTermFreq(1);
		swFilter.setOutputWordCounts(false);
		swFilter.setStemmer(new LovinsStemmer());
		swFilter.setStopwordsHandler(new Rainbow());
		swFilter.setTokenizer(new WordTokenizer());
		swFilter.setWordsToKeep(100);
		// declare a FilteredClassifier object
		FilteredClassifier data_filter = new FilteredClassifier();
		// declare the specific filter
		data_filter.setFilter(swFilter);
		
		//declare the HoeffdingTree classifier 
		HoeffdingTree HDT = new HoeffdingTree();
		
		//the classifier is added to the filter that was previously made
		data_filter.setClassifier(HDT);
		data_filter.buildClassifier(data);
		
		//Declare evaluation object
		Evaluation eval = new Evaluation(data);
		//the HoeffdingTree classifier with filter is passed, along with the data, number of folds and the random seed
		eval.crossValidateModel(data_filter, data, 10, new Random(1));
		
		System.out.println("Finish HoeffdingTree Run");
		System.out.println(eval.toSummaryString());
		System.out.println(eval.toClassDetailsString());
		System.out.println("===== Evaluation based on filtered data is compelet =====");

		
	}
	
	public void filteredJ48Classifier(Instances data) throws Exception  {
		//index the data set
		data.setClassIndex(1);
		// declare a string to word vector filter
		StringToWordVector swFilter = new StringToWordVector();
		//set the range of attributes 
		swFilter.setAttributeIndices("first-last"); 
		//setting filter parameters to that of the weka filter
		swFilter.setIDFTransform(false);
		swFilter.setTFTransform(false);
		swFilter.setNormalizeDocLength(
		new SelectedTag(StringToWordVector.FILTER_NORMALIZE_ALL,
		StringToWordVector.TAGS_FILTER));
		swFilter.setMinTermFreq(1);
		swFilter.setOutputWordCounts(false);
		swFilter.setStemmer(new LovinsStemmer());
		swFilter.setStopwordsHandler(new Rainbow());
		swFilter.setTokenizer(new WordTokenizer());
		swFilter.setWordsToKeep(100);
		// declare a FilteredClassifier object
		FilteredClassifier data_filter = new FilteredClassifier();
		// declare the specific filter
		data_filter.setFilter(swFilter);
		
		//declare the j48 classifier 
		J48 j48 = new J48();
		
		//the classifier is added to the filter that was previously made
		data_filter.setClassifier(j48);
		data_filter.buildClassifier(data);
		
		//Declare evaluation object
		Evaluation eval = new Evaluation(data);
		//the j48 classifier with filter is passed, along with the data, number of folds and the random seed
		eval.crossValidateModel(data_filter, data, 10, new Random(1));
		
		System.out.println("Finish j48 Run");
		System.out.println(eval.toSummaryString());
		System.out.println(eval.toClassDetailsString());
		System.out.println("===== Evaluation based on filtered data is compelet =====");

		
	}

	
	public void filteredSMOClassifier(Instances data) throws Exception  {
		//index the data set
		data.setClassIndex(1);
		// declare a string to word vector filter
		StringToWordVector swFilter = new StringToWordVector();
		//set the range of attributes 
		swFilter.setAttributeIndices("first-last"); 
		//setting filter parameters to that of the weka filter
		swFilter.setIDFTransform(false);
		swFilter.setTFTransform(false);
		swFilter.setNormalizeDocLength(
		new SelectedTag(StringToWordVector.FILTER_NORMALIZE_ALL,
		StringToWordVector.TAGS_FILTER));
		swFilter.setMinTermFreq(1);
		swFilter.setOutputWordCounts(false);
		swFilter.setStemmer(new LovinsStemmer());
		swFilter.setStopwordsHandler(new Rainbow());
		swFilter.setTokenizer(new WordTokenizer());
		swFilter.setWordsToKeep(100);
		// declare a FilteredClassifier object
		FilteredClassifier data_filter = new FilteredClassifier();
		// declare the specific filter
		data_filter.setFilter(swFilter);
		
		//declare the SMO classifier 
		SMO smo = new SMO();
		
		//the classifier is added to the filter that was previously made
		data_filter.setClassifier(smo);
		data_filter.buildClassifier(data);
		
		//Declare evaluation object
		Evaluation eval = new Evaluation(data);
		//the SMO classifier with filter is passed, along with the data, number of folds and the random seed
		eval.crossValidateModel(data_filter, data, 10, new Random(1));
		
		System.out.println("Finish SMO Run");
		System.out.println(eval.toSummaryString());
		System.out.println(eval.toClassDetailsString());
		System.out.println("===== Evaluation based on filtered data is compelet =====");

		
	}
	
	public void filteredIBKClassifier(Instances data) throws Exception {
		//index the data set
		data.setClassIndex(1);
		// declare a string to word vector filter
		StringToWordVector swFilter = new StringToWordVector();
		//set the range of attributes 
		swFilter.setAttributeIndices("first-last"); 
		//setting filter parameters to that of the weka filter
		swFilter.setIDFTransform(false);
		swFilter.setTFTransform(false);
		swFilter.setNormalizeDocLength(
		new SelectedTag(StringToWordVector.FILTER_NORMALIZE_ALL,
		StringToWordVector.TAGS_FILTER));
		swFilter.setMinTermFreq(1);
		swFilter.setOutputWordCounts(false);
		swFilter.setStemmer(new LovinsStemmer());
		swFilter.setStopwordsHandler(new Rainbow());
		swFilter.setTokenizer(new WordTokenizer());
		swFilter.setWordsToKeep(100);
		// declare a FilteredClassifier object
		FilteredClassifier data_filter = new FilteredClassifier();
		// declare the specific filter
		data_filter.setFilter(swFilter);

		
		//declare the IBK classifier 
		IBk ibk = new IBk();
		
		//the classifier is added to the filter that was previously made
		data_filter.setClassifier(ibk);
		data_filter.buildClassifier(data);
		
		//Declare evaluation object
		Evaluation eval = new Evaluation(data);
		//the IBK classifier with filter is passed, along with the data, number of folds and the random seed
		eval.crossValidateModel(data_filter, data, 10, new Random(1));
		
		System.out.println("Finish IBK Run");
		System.out.println(eval.toSummaryString());
		System.out.println(eval.toClassDetailsString());
		System.out.println("===== Evaluation based on filtered data is compelet =====");
	}

}
