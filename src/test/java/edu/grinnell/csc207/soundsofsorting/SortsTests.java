package edu.grinnell.csc207.soundsofsorting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] makeTestArray() {
        return new Integer[] {
            3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10
        };
    }

    public void testSort(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }


    @Test
    public void testBubbleSort() {
        testSort(Sorts::bubbleSort);
    }
    
    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);
    }
    
    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);
    }

    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);
    }
    
    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);
    }

    // New tests added to check event sort with each sorting algorithm.
    // Each function has an array and a copy of that array
    // The copy gets sorted and generates events 
    // according to the specific algorithm whose functionality with eventsort is being checked
    // Then the original array and events are passed into eventsort to see if the array gets 
    // properly sorted
    
    @Test
    public void testEventSortWithBubble(){
        Integer[] arr = makeTestArray();
        Integer[] copy = makeTestArray();

        List<SortEvent<Integer>> events = Sorts.bubbleSort(copy);
        Sorts.eventSort(arr, events);
        assertTrue(sorted(arr));
    }

    @Test
    public void testEventSortWithInsertion(){
        Integer[] arr = makeTestArray();
        Integer[] copy = makeTestArray();

        List<SortEvent<Integer>> events = Sorts.insertionSort(copy);
        Sorts.eventSort(arr, events);
        assertTrue(sorted(arr));
    }

    @Test
    public void testEventSortWithSelection(){
        Integer[] arr = makeTestArray();
        Integer[] copy = makeTestArray();

        List<SortEvent<Integer>> events = Sorts.selectionSort(copy);
        Sorts.eventSort(arr, events);
        assertTrue(sorted(arr));
    }

    @Test
    public void testEventSortWithMerge(){
        Integer[] arr = makeTestArray();
        Integer[] copy = makeTestArray();

        List<SortEvent<Integer>> events = Sorts.mergeSort(copy);
        Sorts.eventSort(arr, events);
        assertTrue(sorted(arr));
    }

    @Test
    public void testEventSortWithQuick(){
        Integer[] arr = makeTestArray();
        Integer[] copy = makeTestArray();

        List<SortEvent<Integer>> events = Sorts.quickSort(copy);
        Sorts.eventSort(arr, events);
        assertTrue(sorted(arr));
    }

}