package demo.sbsolutionsnepal.yoapp.domain.register.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Himal Rai on 2/16/2022
 * SB Solutions Pvt.Ltd
 */
@Setter
@Getter
@Data
@NoArgsConstructor
public class RegisteredMerchantDto {
    private Long id;
    private String merchant_name;
    private String bank_name;
    private String account_number;
    private String phone_number;
    private String city;
    private Float distance;
    private String brand_name;

    public RegisteredMerchantDto(Long id, String merchant_name, String bank_name,
                                 String account_number, String phone_number, String city, float distance, String brand_name) {
        this.id = id;
        this.merchant_name = merchant_name;
        this.bank_name = bank_name;
        this.account_number = account_number;
        this.phone_number = phone_number;
        this.city = city;
        this.distance = distance;
        this.brand_name = brand_name;
    }
}
