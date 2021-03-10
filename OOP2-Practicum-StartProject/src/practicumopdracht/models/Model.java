package practicumopdracht.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Mohammed Malloul
 */


public class Model {

    private final String modelName;
    private final LocalDate releaseDate;
    private final boolean saleChoice;
    private final String color;
    private double price;

    public Model(String modelName, String color, double price, LocalDate releaseDate, boolean saleChoice) {
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

        return "Brand: test" + ":, Model: " + this.modelName + ", Color: " + this.color + ", Price: $"
                + this.price + ", Releasedate: " + formattedDate + ", On sale: " + saleChoice;
    }
}
