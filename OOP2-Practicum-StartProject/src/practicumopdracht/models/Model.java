package practicumopdracht.models;

import java.time.LocalDate;

/**
 * @author Mohammed Malloul
 */


public class Model extends Brand {

    private String modelName;
    private double price;
    private boolean saleChoice;
    private String color;
    private LocalDate releaseDate;

    public Model(String brandName, String modelName, double price, LocalDate releaseDate) {
        super(brandName);
        this.modelName = modelName;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Brand: test" + ":, Model: " + modelName + ", Price: $" + price + ", Releasedate: " + releaseDate;
    }
}
