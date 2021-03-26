package practicumopdracht.data;

import practicumopdracht.models.Brand;

/**
 * @author Mohammed Malloul
 */

public class FakeBrandDAO extends BrandDAO {

    @Override
    public boolean save() {

        return false;
    }

    @Override
    public boolean load() {
        brands.add(new Brand("Samsung", "test", "20000000000", "yes"));
        brands.add(new Brand("Apple", "test", "1000000000000", "no"));
        return true;
    }
}
