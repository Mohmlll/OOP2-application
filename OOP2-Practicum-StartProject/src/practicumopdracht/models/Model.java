package practicumopdracht.models;

import java.time.LocalDate;

public class Model {
    private final int NEUTRAL = 0;
    private final int SALE = 1;
    private String lineUp;
    private final String modelName;
    private final double price;
    private String color;
    private LocalDate releaseDate;
    private final int saleChoice;

    public Model(String lineUp, String modelName, double price, String color, LocalDate releaseDate) {
        this.lineUp = lineUp;
        this.modelName = modelName;
        this.price = price;
        this.color = color;
        this.releaseDate = releaseDate;
        this.saleChoice = 0;
    }

    public Model(String modelName, int saleChoice, double price) {
        this.modelName = modelName;
        this.saleChoice = saleChoice;
        this.price = price;
    }

    public boolean onSale() {
        return this.saleChoice == SALE;
    }


}
