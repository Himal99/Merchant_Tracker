package demo.sbsolutionsnepal.yoapp.base.apiUrl;

import lombok.experimental.UtilityClass;

/**
 * @author Himal Rai on 2/16/2022
 * SB Solutions Pvt.Ltd
 */
@UtilityClass
public class Url {

    public static final String BASE_PACKAGE="demo.sbsolutionsnepal.yoapp";
    public static final String COMPANY_URL="sbsolutionsnepal.com";

    //    Rest APIs
    public static final String REGISTER="/register";
    public static final String SAVE="/save";
    public static final String JSON="/json";
    public static final String GET_BY_ID="/{id}";
    public static final String DELETE_BY_ID="/delete/{id}";
    public static final String PAGE_NOT_FOUND="/not-found";
    public static final String INDEX="/index";
    public static final String BASE="/";
    public static final String PAYMENT="/payment";
    public static final String GET_NEAREST_MERCHANT="/nearestMerchant";
    public static final String MERCHANT_PROFILE="/merchantProfile";
}
