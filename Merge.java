
public class Merge{
	public void merge(int[] arr, Runs runs, int position){
		int i;
		int j;
		int k;
		int leftSize = runs.runs[position][1] - runs.runs[position][0];
		int rightSize = runs.runs[position+1][1] - runs.runs[position+1][0];

		int[] leftTempArr = new int [leftSize];
		int[] rightTempArr = new int[rightSize];

		for(i = 0; i < leftSize; i++){
			leftTempArr[i] = arr[runs.runs[position][0]+i];
		}

		for(j= 0; j < rightSize; j++){
			rightTempArr[j] = arr[runs.runs[position+1][0]+j];
		}

		i = 0;
		j = 0;
		k = runs.runs[position][0];

		while(i < leftSize && j < rightSize){
			if(leftTempArr[i] <= rightTempArr[j]){
				arr[k] = leftTempArr[i];
				i++;
			}else{
				arr[k] = rightTempArr[j];
				j++;
			}
			k++;
		}

		while(i < leftSize){
			arr[k] = leftTempArr[i];
			i++;
			k++;
		}

		while(j < rightSize){
			arr[k] = rightTempArr[j];
			j++;
			k++;
		}
	}


	public void merge(int[] arr, Runs runs){
		int newRuns = runs.runNum;
		while(newRuns > 1){
			for(int i = 0; i < runs.runNum; i = i+2){
				merge(arr, runs, i);
				newRuns--;
			}	
		}
		
	}
}