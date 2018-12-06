/* Sort */
import java.util.Random;
import java.util.*;

class Sort {

	/*
	* Bucket Sort
	*/
	private void bucketSort(float[] arr) {
		//System.out.println(Arrays.toString(arr));
		List<ArrayList<Float>> buckets = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			buckets.add(new ArrayList<Float>());
		}
		for(int i = 0; i < arr.length; i++) {
			buckets.get((int)(arr[i]*10)).add(arr[i]);
		}
		int j = 0;
		for(int i = 0; i < 10; i++) {
			//System.out.println(buckets.get(i).toString());
			Collections.sort(buckets.get(i));
			Iterator itr = buckets.get(i).iterator();
			while(itr.hasNext()) {
				//System.out.println((float) itr.next());
				//System.out.println(j);
				arr[j] = (float) itr.next();
				j++;
			}
			//System.out.println(buckets.get(i).toString());
		}
	}

	/*
	* Bubble Sort
	*/
	private void bubbleSort(float[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length - 1; j++) {
				if(arr[j] > arr[j + 1]) {
					float tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}

	/*
	* Merge Sort
	*/
	private void merge(float[] arr, int l, int m, int h) {

		int n1 = m - l + 1;
		int n2 = h - m;

		float[] sub1 = new float[n1];
		float[] sub2 = new float[n2];

		for(int i = 0; i < n1; i++) {
			sub1[i] = arr[l + i];
		}
		for(int i = 0; i < n2; i++) {
			sub2[i] = arr[m + 1 + i];
		}

		int i = 0;
		int j = 0;
		int k = l;

		while(i < n1 && j < n2) {
			if (sub1[i] <= sub2[j]) {
				arr[k] = sub1[i];
				i++;
			}
			else {
				arr[k] = sub2[j];
				j++;
			}
			k++;
		}

		while(i < n1) {
			arr[k] = sub1[i];
			i++;
			k++;
		}

		while(j < n2) {
			arr[k] = sub2[j];
			j++;
			k++;
		}

	}
	private void mergeSort(float[] arr, int l, int h) {
		if (l < h) {
			int m = (l+h)/2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, h);
			merge(arr, l, m, h);
		}
	}
	private void mergeSort(float[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	/*
	* Quick Sort
	*/
	private int partition(float[] arr, int low, int high) {

		float pivot = arr[high];

		int i = low - 1;

		for(int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				float tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}

		arr[high] = arr[i + 1];
		arr[i + 1] = pivot;
		return i + 1;
	}
	private void quickSort(float[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}
	private void quickSort(float[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	public static void main(String[] args) {

		// Bucket Sort
		Random r = new Random();
		float[] toSort = new float[100];
		for(int i = 0; i < toSort.length ; i++) {
			toSort[i] = r.nextFloat();
		}
		Sort s = new Sort();
		s.bucketSort(toSort);
		System.out.println(Arrays.toString(toSort));
		System.out.println("-");

		// Bubble sort
		for(int i = 0; i < toSort.length ; i++) {
			toSort[i] = r.nextFloat();
		}
		s.bubbleSort(toSort);
		System.out.println(Arrays.toString(toSort));
		System.out.println("-");

		// Merge sort
		for(int i = 0; i < toSort.length ; i++) {
			toSort[i] = r.nextFloat();
		}
		s.mergeSort(toSort);
		System.out.println(Arrays.toString(toSort));
		System.out.println("-");

		// Quick sort
		for(int i = 0; i < toSort.length ; i++) {
			toSort[i] = r.nextFloat();
		}
		s.quickSort(toSort);
		System.out.println(Arrays.toString(toSort));
		System.out.println("-");

	}

}
