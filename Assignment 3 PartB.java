package Assignment;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
 import java.util.*;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
 
class KMeans2D {
 
	public static BufferedReader readDataFile(String filename) {
		BufferedReader inputReader = null;
 
		try {
			inputReader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException ex) {
			System.err.println("File not found: " + filename);
		}
 
		return inputReader;
	}
 
	public static void main(String[] args) throws Exception {
		System.out.println("Enter number of clusters you want : ");
		Scanner input=new Scanner(System.in);
		int k=input.nextInt();
		SimpleKMeans kmeans = new SimpleKMeans();
 
		kmeans.setSeed(10);
 
		//important parameter to set: preserver order, number of cluster.
		kmeans.setPreserveInstancesOrder(true);
		kmeans.setNumClusters(k);
 
		BufferedReader datafile = readDataFile("E:\\Weka\\Weka-3-8-6\\data\\weather.numeric.arff"); 
		Instances data = new Instances(datafile);
		//data.setClassIndex(data.numAttributes() - 1);
		for (int i = 0; i < data.numAttributes(); i++)
		{
		    // Print the current attribute.
		    System.out.print(data.attribute(i).name() + ": ");

		    // Print the values associated with the current attribute.
		    double[] values = data.attributeToDoubleArray(i);
		    System.out.println(Arrays.toString(values));
		}
		kmeans.buildClusterer(data);
 
		// This array returns the cluster number (starting with 0) for each instance
		// The array has as many elements as the number of instances
		int[] assignments = kmeans.getAssignments();
 
		int i=0;
		for(int clusterNum : assignments) {
		    System.out.printf("Instance %d -> Cluster %d \n", i, clusterNum);
		    i++;
		}
	}
}

//E:\\Weka\\Weka-3-8-6\\data\\weather.numeric.arff

Enter number of clusters you want : 
5
outlook: [0.0, 0.0, 1.0, 2.0, 2.0, 2.0, 1.0, 0.0, 0.0, 2.0, 0.0, 1.0, 1.0, 2.0]
temperature: [85.0, 80.0, 83.0, 70.0, 68.0, 65.0, 64.0, 72.0, 69.0, 75.0, 75.0, 72.0, 81.0, 71.0]
humidity: [85.0, 90.0, 86.0, 96.0, 80.0, 70.0, 65.0, 95.0, 70.0, 80.0, 70.0, 90.0, 75.0, 91.0]
windy: [1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0]
play: [1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0]

Instance 0 -> Cluster 3 
Instance 1 -> Cluster 2 
Instance 2 -> Cluster 4 
Instance 3 -> Cluster 0 
Instance 4 -> Cluster 0 
Instance 5 -> Cluster 2 
Instance 6 -> Cluster 1 
Instance 7 -> Cluster 2 
Instance 8 -> Cluster 3 
Instance 9 -> Cluster 0 
Instance 10 -> Cluster 3 
Instance 11 -> Cluster 1 
Instance 12 -> Cluster 4 
Instance 13 -> Cluster 2 
