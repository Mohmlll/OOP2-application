package practicumopdracht.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Mohammed Malloul
 */


public class Model {

    private String modelName;
    private double price;
    private boolean saleChoice;
    private String color;
    private LocalDate releaseDate;
    private Brand brand;

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

        return "Brand: " + this.brand.getBrandName() + ", Model: " + this.modelName + ", Color: " + this.color + ", Price: $"
                + this.price + ", Releasedate: " + formattedDate + ", On sale: " + saleChoice;
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

