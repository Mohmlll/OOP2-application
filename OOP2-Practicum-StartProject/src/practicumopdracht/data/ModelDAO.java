package practicumopdracht.data;

import practicumopdracht.models.Brand;
import practicumopdracht.models.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class ModelDAO implements DAO<Model> {

    protected List<Model> objects;

    public ModelDAO() {
        objects = new ArrayList<>();
    }

    public List<Model> getAllFor(Brand brand) {
        List<Model> results = new ArrayList<>();
        for (Model model : objects) {
            if (model.getBrand() == brand) {

            }
        }
        return results;
    }

    public Model getById(int i) {
        return this.objects.get(i);
    }

    @Override
    public List<Model> getAll() {
        return objects;
    }

    @Override
    public void addOrUpdate(Model object) {
        if (!objects.contains(object)) {
            objects.add(object);
        }
    }

    @Override
    public void remove(Model object) {
        objects.remove(object);
    }

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean load() {
        return false;
    }

}
