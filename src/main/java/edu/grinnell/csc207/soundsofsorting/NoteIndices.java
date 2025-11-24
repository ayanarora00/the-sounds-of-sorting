package edu.grinnell.csc207.soundsofsorting;

import java.util.Random;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {

    /**
     * @param n the size of the scale object that these indices map into
     */

    private Integer[] indices;
    private boolean[] highlight;

    // Constructs shuffled indices array of n elements 
    public NoteIndices(int n) {
        initializeAndShuffle(n);
    }
    
    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size.  The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        
        this.indices = new Integer[n];
        this.highlight = new boolean[n];

        // Initializing the indices array
        for (int i = 0; i < n; i++){
            this.indices[i] = i;
        }

        // Shuffling the indices array using FY_Shuffle
        FY_shuffle(this.indices);
        clearAllHighlighted();

    }
    
    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() { 
        return this.indices;
    }
    
    /**
     * Highlights the given index of the note array
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        this.highlight[index] = true;
    }
    
    /**
     * @param index the index to check
     * @return true if the given index is highlighted
     */
    public boolean isHighlighted(int index) {
        return (this.highlight[index]);
    }
    
    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {

        // Each index of highlight array is set to false(nothing is highlighted anymore)
        for (int i = 0; i < highlight.length; i++){
            this.highlight[i] = false;
        }

    }

    /**This function is used to shuffle the indices array using the Fischer-Yates algorithm
     * 
     * @param  Integer array of indices
     * @return returns nothing
     */
    public void FY_shuffle(Integer[] arr){

        // Initializing random object to create a random integer later on
        Random rand = new Random();

        // Traversing the array in backward direction (as according to the wiki page for the algorithm)
        for (int i = arr.length - 1; i > 0; i--){

            // Declaring j as a random integer between 0 and i
            int j = rand.nextInt(i);

            // Temporary object stores the object at current index (during traversal)
            int temp = arr[i];

            // The element at that position is then assigned to the element at the index of the
            // randomly generated number 
            arr[i] = arr[j];

            // The element at the randomly generated number index is then assigned to the original
            // value of the element at index i
            arr[j] = temp;
        }


    }
}
