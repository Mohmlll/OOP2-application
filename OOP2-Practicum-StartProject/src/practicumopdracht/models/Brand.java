package practicumopdracht.models;

/**
 * @author Mohammed Malloul
 */


public class Brand {
    private String brandName;
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

    public String getCeo() {
        return ceo;
    }

    public String getNetWorth() {
        return netWorth;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Brand: " + brandName + ", CEO: " + this.ceo + ", networth: " + this.netWorth + "\nDescription: " + this.description;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }


    public void setNetWorth(String netWorth) {
        this.netWorth = netWorth;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
