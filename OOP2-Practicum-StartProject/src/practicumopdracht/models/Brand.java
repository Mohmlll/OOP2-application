package practicumopdracht.models;

/**
 * @author Mohammed Malloul
 */


public class Brand {
    private final String brandName;
    private String ceo;
    private String netWorth;
    private String description;


    public Brand(String brandName, String ceo, String netWorth, String description) {
        this.brandName = brandName;
        this.ceo = ceo;
        this.netWorth = netWorth;
        this.description = description;
    }

    public String getBrandName() {
        return brandName;
    }

    @Override
    public String toString() {
        return "Brand: " + brandName + ", CEO: " + this.ceo + ", networth: " + this.netWorth + "\nDescription: " + this.description;
    }
}
