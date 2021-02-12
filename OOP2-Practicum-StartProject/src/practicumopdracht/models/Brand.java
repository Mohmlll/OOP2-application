package practicumopdracht.models;

public class Brand {
    private final String brandName;
    private boolean netWorth;
    private String ceo;

    public Brand(String brandName, boolean netWorth, String ceo) {
        this.brandName = brandName;
        this.netWorth = netWorth;
        this.ceo = ceo;
    }

    public Brand(String brandName) {
        this.brandName = brandName;
    }
}
