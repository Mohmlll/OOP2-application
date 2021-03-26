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

        objects.add(new Model(indexZero, "Galaxy s20+", "Black", 999.0, LocalDate.of(2020, 3, 6), false));
        objects.add(new Model(indexZero, "Galaxy s10+", "Silver", 499.0, LocalDate.of(2019, 2, 20), true));
        objects.add(new Model(indexZero, "Galaxy Note 10", "Gray", 549.0, LocalDate.of(2019, 8, 7), true));
        objects.add(new Model(indexOne, "Iphone 10r", "Red", 345.0, LocalDate.of(2018, 9, 12), true));
        objects.add(new Model(indexOne, "IPhone 12", "Green", 729.0, LocalDate.of(2020, 10, 23), false));
        objects.add(new Model(indexOne, "Ipad air 4", "Black", 599.0, LocalDate.of(2020, 10, 23), false));
        return true;
    }
}