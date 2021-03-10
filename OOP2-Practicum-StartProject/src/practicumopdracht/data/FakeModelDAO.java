package practicumopdracht.data;


public class FakeModelDAO  extends ModelDAO {
    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean load() {
        return false;
    }

}