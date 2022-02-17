package demo.sbsolutionsnepal.yoapp.enums;

/**
 * @author Himal Rai on 2/16/2022
 * SB Solutions Pvt.Ltd
 */
public enum Status {
    ACTIVE("active"), INACTIVE("inactive");
    private final String value;

    Status(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
