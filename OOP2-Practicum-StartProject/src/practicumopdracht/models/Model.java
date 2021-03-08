package practicumopdracht.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String formattedDate = this.releaseDate.format(formatter);

        return "Brand: test" + ":, Model: " + modelName + ", Price: $" + price + ", Releasedate: " + formattedDate;
    }
}
