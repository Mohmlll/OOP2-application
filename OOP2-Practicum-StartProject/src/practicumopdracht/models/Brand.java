package practicumopdracht.models;

/**
 * @author Mohammed Malloul
 */


public class Brand {
    private final String brandName;
    private final String ceo;
    private final String netWorth;
    private final String description;

    public Brand(String brandName, String ceo, String netWorth, String description) {
        this.brandName = brandName;
        this.netWorth = netWorth;
        this.ceo = ceo;
        this.description = description;
    }

    public Brand(String brandName, String ceo, String netWorth) {
        this.brandName = brandName;
        this.netWorth = netWorth;
        this.ceo = ceo;
        this.description = "No descriptrion";
    }

    @Override
    public String toString() {
        return "Brand: " + brandName + ", CEO: " + this.ceo + ", networth: " + this.netWorth + "\nDescription: " + this.description;
    }
}
