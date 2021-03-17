package practicumopdracht.data;

import practicumopdracht.models.Brand;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextBrandDAO extends BrandDAO {

    private final File FILENAME = new File("/data/brands.txt");



    @Override
    public boolean save() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(FILENAME);
            for (Brand brand : this.objects) {
                writer.write(String.format("%s, %s, %s, %s\n",
                        brand.getBrandName(), brand.getCeo(), brand.getNetWorth(), brand.getDescription()));
            }
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }finally {
            if (writer != null){
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

                Brand brand = new Brand(parts[0], parts[1], parts[2], parts[3] );

                this.objects.add(brand);
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
