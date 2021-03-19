package practicumopdracht.data;

import practicumopdracht.models.Brand;

import java.util.ArrayList;
import java.util.List;


public abstract class BrandDAO implements DAO<Brand> {

    protected List<Brand> objects;

    public BrandDAO() {
        objects = new ArrayList<>();
    }

    @Override
    public List<Brand> getAll() {
        return objects;
    }

    @Override
    public void addOrUpdate(Brand object) {
        if (!objects.contains(object)) {
            objects.add(object);
        }
    }

    @Override
    public void remove(Brand object) {
        objects.remove(object);
    }

    @Override
    public abstract boolean save();

    @Override
    public abstract boolean load();

    public Brand getById(int i) {
        return this.objects.get(i);
    }

    public int getIdFor(Brand brand) {
        return this.objects.indexOf(brand);
    }

}
