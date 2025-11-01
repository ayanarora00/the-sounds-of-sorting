package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.Arrays;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T> {

    // Index to which value needs to be copied
    private int index;

    // Value to be copied
    private T value;

    // Constructor
    public CopyEvent(int index, T value){
        this.index = index;
        this.value = value;
    }

    // Array[index] changed to value/value applied to that index of the array
    @Override
    public void apply(T[] arr) {
        arr[index] = value;
    }

    // Returns the index to which value is copied
    @Override
    public List<Integer> getAffectedIndices() {
        return Arrays.asList(index);
    }

    // Returns true since event is said to be emphasized
    @Override
    public boolean isEmphasized() {
        return true;
    }
    
}
