package edu.grinnell.sortingvisualizer.sortevents;
import java.util.ArrayList;
import java.util.List;

public class CopyEvent<T> implements SortEvent<T>{
    private int first_index;
    private T replace;

    public CopyEvent(int fir, T sec) {
        this.first_index = fir;
        this.replace = sec;
    }

    public void apply(T[] arr) {
        arr[this.first_index] = replace;
    }

    public List<Integer> getAffectedIndices(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(this.first_index);
        return list;  
    }

    public boolean isEmphasized() {
        return true;
    }


}
