package practicumopdracht.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Mohammed Malloul
 */

public class Model implements Serializable {

    private String modelName;
    private double price;
    private boolean saleChoice;
    private String color;
    private LocalDate releaseDate;
    private Brand brand;

    /**
     * @param brand       - Brand brand from the model
     * @param modelName   - String name from the model
     * @param color       - String color from the model
     * @param price       - double price from the model
     * @param releaseDate - LocalDate releasedate from the model
     * @param saleChoice  - boolean sales choice from the model
     */
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
        String saleText = "No";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String formattedDate = this.releaseDate.format(formatter);

        if (saleChoice) {
            saleText = "Yes";
        }

        return "Brand: " + this.brand.getBrandName() + ", Model: " + this.modelName + ", Color: " + this.color + "\nPrice: $"
                + this.price + ", Releasedate: " + formattedDate + ", On sale: " + saleText;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getModelName() {
        return modelName;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSaleChoice() {
        return saleChoice;
    }

    public String getColor() {
        return color;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setSaleChoice(boolean saleChoice) {
        this.saleChoice = saleChoice;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}

