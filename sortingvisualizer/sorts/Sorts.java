package edu.grinnell.sortingvisualizer.sorts;
import java.util.ArrayList;
import java.util.List;

import edu.grinnell.sortingvisualizer.sortevents.*;

public class Sorts {

    /**
     * swaps two elements of an array
     * @param arr the array in which the elements will be swapped
     * @param a the index of the first element being swapped
     * @param b the index of the second element being swapped
     */
    public static <T> void swap(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * sorts an array with the selection technique
     * @param arr the array to be sorted
     * @returns List of SortEvents that records the actions needed to sort arr using selection Sort
     */
    public static <T extends Comparable<T>> List<SortEvent<T>> selectionSort(T[] arr) {
        List<SortEvent<T>> events = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++) {
            int sm_index = i;

            for(int j = i ; j < arr.length ; j++) {
                events.add(new CompareEvent<T>(i,j));
                if(arr[j].compareTo(arr[sm_index])<0) sm_index = j;

            }
            events.add(new SwapEvent<T>(i,sm_index));
            swap(arr, sm_index, i);
        }
        return events;
    }



    /**
     * sorts an array with the insertion technique
     * @param arr the array to be sorted
     * @return a list of SortEvents that records the actions needed to sort arr by insertion technique
     */
    public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(T[] arr) {
        List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
        for(int i = 0 ; i < arr.length ; i++) {
            for(int j = i; j> 0; j--) {
                int x = j - 1;
                events.add(new CompareEvent<T>(x,j));
                if(arr[x].compareTo(arr[j]) > 0) {
                    events.add(new SwapEvent<T>(x,j));
                    swap(arr, x, j);
                }
            }

        }
        return events;
    }

    /**
     * pre: both halves of the array must be sorted
     * sorts an array using the merge technique from lo to hi
     * @param arr the array to sorted
     * @param lo the lower bound index
     * @param hi the upper bound index
     * @param mid the index between lo and hi
     * @return A list of SortEvents that records the actions needed to merge sort arr
     */
    public static <T extends Comparable<T>> List<SortEvent<T>> merge(T[] arr, int lo, int hi, int mid, List<SortEvent<T>> events) {
        Object[] merged = new Object[hi-lo+1];
        int i = lo;
        int j = mid+1;
        int k = 0;
        while(i <= mid && j <= hi){
            events.add(new CompareEvent<T>(i,j));
            if(arr[i].compareTo(arr[j])>0) {
                merged[k++] = arr[j];
                j++;
            }else {
                merged[k++] = arr[i];
                i++;
            }

        }

        while(j <= hi) {
            merged[k++] = arr[j];
            j++;
        }

        while(i <= mid) {
            merged[k++] = arr[i];
            i++;
        }

        for(int a = 0 ; a<merged.length; a++) {
            events.add(new CopyEvent<T>(lo+a,(T) merged[a]));
            arr[lo+a] = (T) merged[a];
        }

        return events;
    }

    /**
     * Merge sort helper that sorts both left and right side of an array recursively from lo to hi
     * @param arr the array to be sorted
     * @param lo the lower bound index
     * @param hi the upper bound index
     * @return A list of SortEvents that records the actions needed to merge sort arr
     */
    public static <T extends Comparable<T>> List<SortEvent<T>> mergeSortHelper(T[] arr, int lo, int hi, List<SortEvent<T>> events) {
        if(lo<hi) {
            int mid = lo + (hi-lo)/2;

            //Sorting the left half
            events = mergeSortHelper(arr,lo,mid, events);

            //Sorting the right half
            events = mergeSortHelper(arr,mid+1,hi, events);

            //Merge the sorted parts
            events = merge(arr,lo,hi,mid, events);
        }

        return events;
    }

    /**
     * Driver method behind merge sort
     * @param arr the array to be sorted
     * @return A list of SortEvents that records the actions needed to merge sort arr
     */
    public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(T[] arr) {
        List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
        events = mergeSortHelper(arr,0,arr.length-1, events);
        return events;
    }


    /**
     * Sorts an array with the Bubble (sinking) sort technique
     * @param arr The array to be sorted
     * @return an ArrayList of SortEvents that records the actions needed to bubble sort arr
     */
    public static <T extends Comparable<? super T>> ArrayList<SortEvent<T>> bubbleSort(T[] arr) { 
        ArrayList<SortEvent<T>> events = new ArrayList<>();
        int n = arr.length;  

        for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){  
                events.add(new CompareEvent<T>(j-1,j));
                if(arr[j-1].compareTo(arr[j])>0){  
                    events.add(new SwapEvent<T>(j-1,j));
                    swap(arr,j-1,j); 
                }
            }
        }
        return events;
    }

    /**
     * Finds the best pivot point of array arr
     * @param arr the array you want to find pivot of
     * @param fir the first index
     * @param mid the second index
     * @param last the last index
     * @return Median of a, b, c, which should be used as pivot for quicksort
     */
    public static <T extends Comparable<? super T>> int findMedianIndex(T[]arr, int fir, int mid, int last) {
        T answer = arr [mid];
        if(answer.compareTo(arr[fir])>0) {
            if(answer.compareTo(arr[last])<0) {
                return mid;
            }else {
                return last;
            }
        }else {
            if(answer.compareTo(arr[last])>0) {
                return mid; 
            }else {
                return fir;
            }
        }
    }

    /**
     * Quicksort helper method that sorts array from arr[lo] to arr[hi]
     * @param arr the array to be sorted
     * @param lo the low end of the array 
     * @param hi the high end of the array
     * @return A list of SortEvents that records the actions needed to Quick Sort arr
     */
    public static <T extends Comparable<? super T>> List<SortEvent<T>> quicksortHelper(T[] arr, int lo, int hi, List<SortEvent<T>> events) {

        if (lo>= hi) return events;
        int midIndex = lo + (hi - lo) / 2;
        int quicksortMedian = findMedianIndex(arr, lo, midIndex, hi);
        int i = lo;
        int j = hi-1;
        events.add(new SwapEvent<T>(quicksortMedian, hi));
        swap(arr, quicksortMedian, hi);

        if(i == j && arr[lo].compareTo(arr[hi])<0) {
            return events;
        }

        while(i < j) {

            while(arr[i].compareTo(arr[hi]) < 0) {
                events.add(new CompareEvent<T>(i,hi));
                i++;
            }	

            while(arr[j].compareTo(arr[hi]) > 0 && j >= i) {
                events.add(new CompareEvent<T>(j,hi));
                j--;
            }


            if(i < j) {
                events.add(new CompareEvent<T>(i,j));
                events.add(new SwapEvent<T>(i,j));
                swap(arr, i, j);
            }
        }

        //splitting the array
        events.add(new SwapEvent<T>(i,hi));
        swap(arr, i, hi);

        // sorting our two split arrays
        events = quicksortHelper(arr, lo, j, events);
        events = quicksortHelper(arr, j+1, hi, events); //i
        return events;
    }

    /**
     * Quicksorts the array arr
     * @param arr the array to be sorted
     * @return A list of SortEvents that records the actions needed to QuickSort arr
     */
    public static <T extends Comparable<? super T>> List<SortEvent<T>> quicksort(T[] arr) {
        List<SortEvent<T>> events = new ArrayList<>();
        events = quicksortHelper(arr, 0, arr.length - 1, events);
        return events;
    }

    /**
     * Takes an array of Ts and sorts them with the instructions of events 
     * @param l An array of Ts that needs to be sorted
     * @param events A list of Sort Events that tells how to sort l if done in order
     */
    public static <T> void eventSort(T[] l, List<SortEvent<T>> events) {
        for(SortEvent event:events) {
            event.apply(l);
        }
    }  
}
