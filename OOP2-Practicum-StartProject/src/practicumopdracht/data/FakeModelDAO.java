package practicumopdracht.data;


import practicumopdracht.MainApplication;
import practicumopdracht.models.Brand;
import practicumopdracht.models.Model;

import java.time.LocalDate;

public class FakeModelDAO  extends ModelDAO {
    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean load() {
        Brand indexOne = MainApplication.getBrandDAO()/getById(0);
//        Brand indexTwo = MainApplication.getBrandDAO().

        objects.add(new Model(indexOne, "Galaxy s20+", "Black", 999,LocalDate.of(2020,3,15),false));
        return true;
    }



}