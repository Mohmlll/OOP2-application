package practicumopdracht.comparators;

import practicumopdracht.models.Model;

import java.util.Comparator;

/**
 * Comparator for the models
 *
 * @author Mohammed Malloul
 */

public class ModelComparator implements Comparator<Model> {

    private boolean sortDescending;

    /**
     * @param sortDescending - boolean to check white kind of sorting is required
     */
    public ModelComparator(boolean sortDescending) {
        this.sortDescending = sortDescending;
    }

    /**
     * @param o1 - Model model
     * @param o2 -  Model model
     * @return returns a type of compare depending on the value of sortDescending
     */
    @Override
    public int compare(Model o1, Model o2) {
        if (sortDescending) {
            return o1.toString().compareTo(o2.toString());
        } else {
            return o2.toString().compareTo(o1.toString());
        }
    }
}
