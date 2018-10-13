package BL;

import java.util.Comparator;


public class SortierNachFrequenz implements Comparator<Sender>{

    @Override
    public int compare(Sender o1, Sender o2) {
        if(o1.getFrequenz() < o2.getFrequenz()) return -1;
        if (o1.getFrequenz() > o2.getFrequenz()) return 1;
        return 0;
    }
}