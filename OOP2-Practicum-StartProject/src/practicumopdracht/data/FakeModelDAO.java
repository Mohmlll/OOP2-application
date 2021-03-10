package practicumopdracht.data;

import java.util.List;

public class FakeModelDAO  extends ModelDAO{

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void addOrUpdate(Object object) {

    }

    @Override
    public void remove(Object object) {

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
