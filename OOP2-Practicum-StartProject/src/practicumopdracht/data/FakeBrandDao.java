package practicumopdracht.data;

import practicumopdracht.models.Brand;

public class FakeBrandDao extends BrandDAO {

    @Override
    public boolean save() {

        return false;
    }

    @Override
    public boolean load() {
        objects.add(new Brand("Samsung", "test", "20000000000", "yes"));
        objects.add(new Brand("Apple", "test", "1000000000000", "no"));
        return true;
    }
}
