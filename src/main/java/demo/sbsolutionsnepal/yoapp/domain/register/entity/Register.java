package demo.sbsolutionsnepal.yoapp.domain.register.entity;

import demo.sbsolutionsnepal.yoapp.base.baseDomain.BaseEntity;
import demo.sbsolutionsnepal.yoapp.domain.register.category.entity.RegisterCategory;
import demo.sbsolutionsnepal.yoapp.domain.register.dto.RegisteredMerchantDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Himal Rai on 2/16/2022
 * SB Solutions Pvt.Ltd
 */
@Entity
@Table(name = "tbl_register")
@Getter
@Setter
@SqlResultSetMapping(name = "RegisteredMerchantDtoMapping",
        classes = @ConstructorResult(targetClass = RegisteredMerchantDto.class,
                columns = {@ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "merchant_name", type = String.class),
                        @ColumnResult(name = "bank_name", type = String.class),
                        @ColumnResult(name = "account_number", type = String.class),
                        @ColumnResult(name = "phone_number", type = String.class),
                        @ColumnResult(name = "city", type = String.class),
                        @ColumnResult(name = "distance", type = Float.class),
                        @ColumnResult(name = "brand_name", type = String.class),
                }))
public class Register extends BaseEntity {

    private Long id;
    private String merchantName;
    private String bankName;
    private String accountNumber;
    private String city;
    private String phoneNumber;
    private String brandName;
    private Double longitude;
    private Double latitude;

    @OneToOne
    RegisterCategory category;


}
