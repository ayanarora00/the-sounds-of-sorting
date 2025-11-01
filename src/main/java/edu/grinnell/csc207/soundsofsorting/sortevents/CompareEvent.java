package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.Arrays;
import java.util.List;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T> implements SortEvent<T> {

    // The 2 indices between which the comparison is done for the sort
    private int index1;
    private int index2;

    // Constructor for compareEvent
    public CompareEvent(int index1, int index2){
        this.index1 = index1;
        this.index2 = index2;
    }

    // Nothing to apply, this is only a comparison so we don't log a change in the array
    @Override
    public void apply(T[] arr) {

    }

    // This function returns affected indices, i.e. index1 and index2
    @Override
    public List<Integer> getAffectedIndices() {
        return Arrays.asList(this.index1, this.index2);
    }

    // Since event isn't emphasized, false is returned
    @Override
    public boolean isEmphasized() {
        return false;
    }
    

}
