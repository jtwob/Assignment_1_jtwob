
import java.util.Random;

public class Engine extends Merge{
	public static void main(String[] args){
		Random ran = new Random();
		int[] arr = new int[50000];
		for(int i = 0; i < arr.length; i++){
			arr[i] = ran.nextInt(100000);
		}
	Runs runs = findRuns(arr);
	merge(arr, runs);
	}
}