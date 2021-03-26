package practicumopdracht.data;


import practicumopdracht.MainApplication;
import practicumopdracht.models.Brand;
import practicumopdracht.models.Model;

import java.time.LocalDate;

/**
 * @author Mohammed Malloul
 */

public class FakeModelDAO extends ModelDAO {
    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean load() {
        Brand indexZero = MainApplication.getBrandDAO().getById(0);
        Brand indexOne = MainApplication.getBrandDAO().getById(1);

        objects.add(new Model(indexZero, "Galaxy s20+", "Black", 999, LocalDate.of(2020, 3, 15), false));
        objects.add(new Model(indexOne, "IPhone 11", "Black", 700, LocalDate.of(2020, 9, 15), true));
        return true;
    }
}