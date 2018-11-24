
public class Runs{
	protected int[][] runs;
	protected int runSize;
	protected int runNum;

	public Runs(){
		runNum = 0;
		runSize = 16;
		runs = new int[50000][2];
	}

	public Runs findRuns(int[] arr){
		int start = 0;
		int end = 1;
		runNum = 0;
		int temp = start;
		Runs run = new Runs();

		while(end <= arr.length){
			if(arr[temp] <= arr[end]){
				while(!checkAddRun(start, end)){
					temp++;
					end++;
				}
				while(checkAddRun(start, end)){
					if(arr[end] > arr[end+1]){
						run.runs[runNum][0] = start;
						run.runs[runNum][1] = end;
						run.runNum++;
						start = end+1;
						end = end + 2;
						temp = start;
					}else{
						temp++;
						end++;
					}
				}
			}else{
				while(!checkAddRun(start, end)){
					end = runSize - (end - start);
					inPlaceInsertionSort(arr, start, end);
					run.runs[runNum][0] = start;
					run.runs[runNum][1] = end;
					runNum++;
					start = end + 1; 
					end = start + 1;
					temp = start;
				}
			}
		}
		return run;
	}

	public boolean checkAddRun(int start, int end){
		if(end - start >= runSize){
			return true;
		}
		return false;
	}

	public void inPlaceInsertionSort(int[] arr, int start, int end){
		for(int i = start; i < end; i++){
			int pivot = arr[i];
			int j = i-1;

			while(j >= 0 && arr[j] > pivot){
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[j+1] = pivot;
		}
	}


}

