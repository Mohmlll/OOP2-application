package practicumopdracht.comparators;

import practicumopdracht.models.Model;

import java.util.Comparator;

public class ModelComparator implements Comparator<Model> {

    @Override
    public int compare(Model o1, Model o2) {
        return o1.toString().compareTo(o2.toString());
    }
}
