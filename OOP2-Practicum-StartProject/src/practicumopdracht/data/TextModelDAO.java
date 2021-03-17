package practicumopdracht.data;

import practicumopdracht.MainApplication;
import practicumopdracht.models.Brand;
import practicumopdracht.models.Model;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class TextModelDAO extends ModelDAO{

    private final File FILENAME = new File("models.txt");
    private BrandDAO brandDAO = MainApplication.getBrandDAO();

    @Override
    public boolean save() {
        PrintWriter writer = null;
        try{
            writer = new PrintWriter(FILENAME);
            for(Model models : this.objects){
                writer.write(String.format("%s,%s,%s,%s,%s,%s\n",
                        models.getBrand(), models.getModelName(), models.getColor(),
                        models.getPrice(), models.getReleaseDate(), models.isSaleChoice()));
            }
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }finally {
            if(writer != null){
                writer.close();
            }
        }
    }

    @Override
    public boolean load() {
        if(!FILENAME.exists()){
            return true;
        }

        Scanner scanner = null;
        try{
            scanner = new Scanner(this.FILENAME);
            while(scanner.hasNextLine()){
                String rawLine = scanner.nextLine();
                String[] parts = rawLine.split(",");

                int mandId = Integer.parseInt(parts[2]);
                Brand brand = brandDAO.getById(mandId);

                Model model = new Model(brand, parts[0], parts[1], Double.parseDouble(parts[2]), LocalDate.parse(parts[3]), Boolean.parseBoolean(parts[4]));

                this.objects.add(model);
            }
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }finally{
            scanner.close();
        }
    }
}
