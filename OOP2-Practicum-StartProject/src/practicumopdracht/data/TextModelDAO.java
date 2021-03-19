package practicumopdracht.data;

import practicumopdracht.MainApplication;
import practicumopdracht.models.Brand;
import practicumopdracht.models.Model;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class TextModelDAO extends ModelDAO {

    private final File FILENAME = new File("models.txt");
    private final BrandDAO brandDAO = MainApplication.getBrandDAO();

    @Override
    public boolean save() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(FILENAME);
            for (Model models : this.objects) {
                int brandId = brandDAO.getIdFor(models.getBrand());
                writer.write(String.format("%s,%s,%s,%s,%s,%s\n",
                        brandId, models.getModelName(), models.getColor(),
                        models.getPrice(), models.getReleaseDate(), models.isSaleChoice()));
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    @Override
    public boolean load() {
        if (!FILENAME.exists()) {
            return true;
        }

        Scanner scanner = null;
        try {
            scanner = new Scanner(this.FILENAME);
            while (scanner.hasNextLine()) {
                String rawLine = scanner.nextLine();
                String[] parts = rawLine.split(",");

                int brandId = Integer.parseInt(parts[0]);

                Brand brand = brandDAO.getById(brandId);

                Model model = new Model(brand, parts[1], parts[2], Double.parseDouble(parts[3]), LocalDate.parse(parts[4]), Boolean.parseBoolean(parts[5]));

                this.objects.add(model);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            scanner.close();
        }
    }
}
