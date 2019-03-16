import static org.junit.Assert.*;

import org.junit.Test;

import edu.grinnell.sortingvisualizer.sorts.Sorts;

public class SortsTest {

    /* ------------------------------------------------------------- Test Suite for Selection Sort ------------------------------------------------------------ */	
    @Test
    public void testSelectionSort1() {
        Integer[] test = {3,9,2,8,6,4,1,7,5};
        Sorts.selectionSort(test);
        Integer[] sorted = {1,2,3,4,5,6,7,8,9};
        assertArrayEquals(test, sorted);

    }

    @Test
    public void testSelectionSort2() {
        Integer[] test = {2,8,2,0,2,3,1,4};
        Sorts.selectionSort(test);
        Integer[] sorted = {0,1,2,2,2,3,4,8};
        assertArrayEquals(test, sorted);

    }

    @Test
    public void testSelectionSort3() {
        Integer[] test = {19302, 478901, 174839275, 1, 8695045};
        Sorts.selectionSort(test);
        Integer[] sorted = {1, 19302, 478901,8695045, 174839275};
        assertArrayEquals(test, sorted);

    }


    /* ------------------------------------------------------------- Test Suite for Insertion Sort ------------------------------------------------------------- */	
    @Test
    public void testInsertionSort1() {
        Integer[] test = {3,9,2,8,6,4,1,7,5};
        Sorts.insertionSort(test);
        Integer[] sorted = {1,2,3,4,5,6,7,8,9};
        assertArrayEquals(test, sorted);

    }

    @Test
    public void testInsertionSort2() {
        Integer[] test = {2,8,2,0,2,3,1,4};
        Sorts.insertionSort(test);
        Integer[] sorted = {0,1,2,2,2,3,4,8};
        assertArrayEquals(test, sorted);

    }

    @Test
    public void testInsertionSort3() {
        Integer[] test = {19302, 478901, 174839275, 1, 8695045};
        Sorts.insertionSort(test);
        Integer[] sorted = {1, 19302, 478901,8695045, 174839275};
        assertArrayEquals(test, sorted);

    }


    /* ------------------------------------------------------------- Test Suite for Bubble Sort ------------------------------------------------------------------ */	
    @Test 
    public void testBubbleSort1() {
        Integer[] test = {3,9,2,8,6,4,1,7,5};
        Sorts.bubbleSort(test);
        Integer[] sorted = {1,2,3,4,5,6,7,8,9};
        assertArrayEquals(test, sorted);
    }

    @Test 
    public void testBubbleSort2() {
        Integer[] test = {2,8,2,0,2,3,1,4};
        Sorts.bubbleSort(test);
        Integer[] sorted = {0,1,2,2,2,3,4,8};
        assertArrayEquals(test, sorted);
    }

    @Test 
    public void testBubbleSort3() {
        Integer[] test = {19302, 478901, 174839275, 1, 8695045};
        Sorts.bubbleSort(test);
        Integer[] sorted = {1, 19302, 478901,8695045, 174839275};
        assertArrayEquals(test, sorted);
    }


    /* ------------------------------------------------------------ Test Suite for Merge Sort ----------------------------------------------------------------------- */	
    @Test
    public void testMergeSort1() {
        Integer[] testarr = {3,7,0,4,0,2,1,9,9,7,0,6,2,8,3,0,4,5};
        Sorts.mergeSort(testarr);
        Integer[] sorted = {0,0,0,0,1,2,2,3,3,4,4,5,6,7,7,8,9,9};
        assertArrayEquals(testarr, sorted);
    }

    @Test
    public void testMergeSort2() {
        Integer[] testarr = {2,8,2,0,2,3,1,4};
        Sorts.mergeSort(testarr);
        Integer[] sorted = {0,1,2,2,2,3,4,8};
        assertArrayEquals(testarr, sorted);
    }

    @Test
    public void testMergeSort3() {
        Integer[] testarr = {19302, 478901, 174839275, 1, 8695045};
        Sorts.mergeSort(testarr);
        Integer[] sorted = {1, 19302, 478901,8695045, 174839275};   
        assertArrayEquals(testarr, sorted);
    }



    /* ------------------------------------------------------------ Test Suite for Quick Sort ----------------------------------------------------------------------- */			
    @Test 
    public void testQuickSort1() {
        Integer[] test = {3,9,2,8,6,4,1,7,5};
        Sorts.quicksort(test);
        Integer[] sorted = {1,2,3,4,5,6,7,8,9};
        assertArrayEquals(test, sorted);
    } 

    @Test 
    public void testQuickSort2() {
        Integer[] test = {1,4,8,2,1,10};
        Sorts.quicksort(test);
        Integer[] sorted = {1,1,2,4,8,10};
        assertArrayEquals(test, sorted);
    }

    @Test 
    public void testQuickSort3() {
        Integer[] test = {4,8,1,22,4,1,5,6};
        Sorts.quicksort(test);
        Integer[] sorted = {1,1,4,4,5,6,8,22};
        assertArrayEquals(test, sorted);

    } 

    @Test 
    public void testQuickSort4() {
        Integer[] test = {4,8,1,22,4,1,5,6};
        Sorts.quicksort(test);
        Integer[] sorted = {1,1,4,4,5,6,8,22};
        for(Integer i:test) {
            System.out.println(i);
        }
        assertArrayEquals(test, sorted);

    } 
}
