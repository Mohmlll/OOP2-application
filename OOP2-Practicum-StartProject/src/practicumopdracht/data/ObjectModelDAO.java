package practicumopdracht.data;

import practicumopdracht.MainApplication;
import practicumopdracht.models.Brand;
import practicumopdracht.models.Model;

import java.io.*;
import java.time.LocalDate;

/**
 * @author Mohammed Malloul
 */

public class ObjectModelDAO extends ModelDAO {
    private final File FILENAME = new File("models.dat");

    private final BrandDAO brandDAO = MainApplication.getBrandDAO();

    @Override
    public boolean save() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            outputStream.writeInt(this.objects.size());

            for (Model model : this.objects) {
                int brandId = brandDAO.getIdFor(model.getBrand());
                outputStream.writeInt(brandId);
                outputStream.writeUTF(model.getModelName());
                outputStream.writeUTF(model.getColor());
                outputStream.writeDouble(model.getPrice());
                outputStream.writeObject(model.getReleaseDate());
                outputStream.writeBoolean(model.isSaleChoice());
            }
            //makes sure the file is closed and the file is free.
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            int numberOfModels = objectInputStream.readInt();

            for (int i = 0; i < numberOfModels; i++) {

                int brandId = objectInputStream.readInt();
                Brand brand = brandDAO.getById(brandId);

                String nameModel = objectInputStream.readUTF();
                String color = objectInputStream.readUTF();
                double price = objectInputStream.readDouble();
                LocalDate releasedate = (LocalDate) objectInputStream.readObject();
                boolean salesChoice = objectInputStream.readBoolean();

                Model model = new Model(brand, nameModel, color, price, releasedate, salesChoice);
                this.objects.add(model);
            }
            //makes sure the file is closed and the file is free.
            objectInputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Something went wrong while loading!");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong while reading!");
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Something went wrong while loading the Brand class!");
            return false;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Index of brand from model is not correct!");
            return false;
        }
    }
}
