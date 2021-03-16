package practicumopdracht.data;

import practicumopdracht.models.Brand;

public class FakeBrandDao extends BrandDAO {

    @Override
    public boolean save() {

        return false;
    }

    @Override
    public boolean load() {
        objects.add(new Brand("Samsung", "test", "Billions", "yes"));
        objects.add(new Brand("Apple", "test", "Trillion", "no"));
        return true;
    }
}
