package practicumopdracht.models;

/**
 * @author Mohammed Malloul
 */


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

    public String getBrandName() {
        return brandName;
    }

    public boolean isNetWorth() {
        return netWorth;
    }

    public String getCeo() {
        return ceo;
    }

    @Override
    public String toString() {
        return brandName;
    }
}
