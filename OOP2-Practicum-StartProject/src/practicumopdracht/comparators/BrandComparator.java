package practicumopdracht.comparators;

import practicumopdracht.models.Brand;

import java.util.Comparator;

/**
 * Comparator from the brands
 *
 * @author Mohammed Malloul
 */

public class BrandComparator implements Comparator<Brand> {

    private boolean sortDescending;

    /**
     * @param sortDescending - boolean to check white kind of sorting is required
     */
    public BrandComparator(boolean sortDescending) {
        this.sortDescending = sortDescending;
    }

    /**
     * @param o1 - Brand brand
     * @param o2 -  Brand brand
     * @return returns a type of compare depending on the value of sortDescending
     */
    @Override
    public int compare(Brand o1, Brand o2) {
        if (sortDescending) {
            return o1.toString().compareTo(o2.toString());
        } else {
            return o2.toString().compareTo(o1.toString());
        }
    }
}
