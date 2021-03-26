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
     * Methods compares using the toString()
     *
     * @param m1 - Model model 1
     * @param m2 - Model model 2
     * @return returns a type of compare depending on the value of sortDescending
     */
    @Override
    public int compare(Model m1, Model m2) {
        if (sortDescending) {
            return m1.toString().compareTo(m2.toString());
        } else {
            return m2.toString().compareTo(m1.toString());
        }
    }


}

