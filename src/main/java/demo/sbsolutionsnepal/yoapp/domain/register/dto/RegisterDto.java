package demo.sbsolutionsnepal.yoapp.domain.register.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Himal Rai on 2/18/2022
 * SB Solutions Pvt.Ltd
 */
@Getter
@Setter
public class RegisterDto {
    private String merchantName;
    private String bankName;
    private String accountNumber;
    private String phoneNumber;
    private String brandName;
    private Double longitude;
    private Double latitude;
    private Long categoryId;
}
