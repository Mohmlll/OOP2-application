package practicumopdracht.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Mohammed Malloul
 */


public class Model {

    private final String modelName;
    private double price;
    private final boolean saleChoice;
    private final String color;
    private final LocalDate releaseDate;
    private final Brand brand;

    public Model(Brand brand, String modelName, String color, double price, LocalDate releaseDate, boolean saleChoice) {
        this.brand = brand;
        this.modelName = modelName;
        this.color = color;
        this.price = price;
        this.releaseDate = releaseDate;
        this.saleChoice = saleChoice;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String formattedDate = this.releaseDate.format(formatter);

        return "Brand: "+this.brand.getBrandName() + ", Model: " + this.modelName + ", Color: " + this.color + ", Price: $"
                + this.price + ", Releasedate: " + formattedDate + ", On sale: " + saleChoice;
    }

    public Brand getBrand() {
        return brand;
    }
}

