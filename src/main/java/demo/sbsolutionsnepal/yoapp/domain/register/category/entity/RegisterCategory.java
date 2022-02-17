package demo.sbsolutionsnepal.yoapp.domain.register.category.entity;

import demo.sbsolutionsnepal.yoapp.base.baseDomain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author Himal Rai on 2/17/2022
 * SB Solutions Pvt.Ltd
 */
@Entity
@Getter
@Setter
public class RegisterCategory extends BaseEntity {

    private Long id;
    private String categoryName;
}
