package practicumopdracht.comparators;

import practicumopdracht.models.Brand;

import java.util.Comparator;

public class BrandComparator implements Comparator<Brand> {
    private boolean sortDescending;

    public BrandComparator(boolean sortDescending) {
        this.sortDescending = sortDescending;
    }

    @Override
    public int compare(Brand o1, Brand o2) {
        if (sortDescending){
            return o1.toString().compareTo(o2.toString());
        }else{
            return o2.toString().compareTo(o1.toString());
        }
    }
}
