package practicumopdracht.data;

import practicumopdracht.models.Brand;

import java.util.ArrayList;
import java.util.List;


public abstract class BrandDAO implements DAO<Brand> {

    protected List<Brand> brands;

    public BrandDAO() {
        brands = new ArrayList<>();
    }

    @Override
    public List<Brand> getAll() {
        return brands;
    }

    @Override
    public void addOrUpdate(Brand object) {
        if (!brands.contains(object)) {
            brands.add(object);
        }
    }

    @Override
    public void remove(Brand object) {
        brands.remove(object);
    }

    @Override
    public abstract boolean save();

    @Override
    public abstract boolean load();
}
