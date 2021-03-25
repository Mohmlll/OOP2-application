package practicumopdracht.comparators;

import practicumopdracht.models.Model;

import java.util.Comparator;

public class ModelComparator implements Comparator<Model> {

    private boolean sortDescending;

    public ModelComparator(boolean sortDescending) {
        this.sortDescending = sortDescending;
    }

    @Override
    public int compare(Model o1, Model o2) {
        if (sortDescending) {
            return o1.toString().compareTo(o2.toString());
        } else {
            return o2.toString().compareTo(o1.toString());
        }
    }
}
