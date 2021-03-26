package practicumopdracht.data;

import practicumopdracht.models.Brand;

import java.io.*;

/**
 * @author Mohammed Malloul
 */

public class BinaryBrandDAO extends BrandDAO {

    private final File FILENAME = new File("brands.dat");

    @Override
    public boolean save() {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME);
            DataOutputStream outputStream = new DataOutputStream(fileOutputStream);

            outputStream.writeInt(this.brands.size());

            for (Brand brand : this.brands) {
                outputStream.writeUTF(brand.getBrandName());
                outputStream.writeUTF(brand.getCeo());
                outputStream.writeUTF(brand.getNetWorth());
                outputStream.writeUTF(brand.getDescription());
            }
            //makes sure the file is closed and the file is free.
            outputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong while saving!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong while writing");
        }
        return false;
    }

    @Override
    public boolean load() {
        if (!FILENAME.exists()) {
            return true;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAME);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);

            int numberOfBrands = dataInputStream.readInt();
            //clears the list before loading the new data from the file
            this.brands.clear();
            for (int i = 0; i < numberOfBrands; i++) {
                String nameBrand = dataInputStream.readUTF();
                String nameCEO = dataInputStream.readUTF();
                String networth = dataInputStream.readUTF();
                String description = dataInputStream.readUTF();

                Brand brand = new Brand(nameBrand, nameCEO, networth, description);
                this.brands.add(brand);
            }
            //makes sure the file is closed and the file is free.
            dataInputStream.close();
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("something went wrong");
            return false;
        }
    }
}
