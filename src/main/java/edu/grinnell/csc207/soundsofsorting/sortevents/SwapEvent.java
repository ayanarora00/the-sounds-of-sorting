package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.Arrays;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T>{

    // The 2 indices between which the swap has to be logged
    private int index1;
    private int index2;

    // constructor
    public SwapEvent(int index1, int index2){
        this.index1 = index1;
        this.index2 = index2;
    }

    // The swap being applied to the array
    @Override
    public void apply(T[] arr) {
        T tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    // The 2 indices returned as affected indices
    @Override
    public List<Integer> getAffectedIndices() {
        return Arrays.asList(this.index1, this.index2);
    }

    // Gives true since the event is emphasized
    @Override
    public boolean isEmphasized() {
        return true;
    }
    
}
