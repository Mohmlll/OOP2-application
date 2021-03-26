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
        brands.add(new Brand("Samsung", "Kim Hyun Suk, Koh Dong-Jin, Kim Ki Nam", "???", "Biggest company in korea"));
        brands.add(new Brand("Apple", "Tim Cook", "1 Trillion", "One of the biggest companies on the world"));
        return true;
    }
}
