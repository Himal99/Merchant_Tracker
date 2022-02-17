package demo.sbsolutionsnepal.yoapp.domain.register.category.service;

import demo.sbsolutionsnepal.yoapp.domain.register.category.entity.RegisterCategory;

import java.util.List;

/**
 * @author Himal Rai on 2/17/2022
 * SB Solutions Pvt.Ltd
 */
public interface RegisterCategoryService {
    RegisterCategory save(RegisterCategory registerCategory);
    List<RegisterCategory> getAll();
    RegisterCategory findOne(Long id);
    void saveAll(List<RegisterCategory> registerCategories);
}
