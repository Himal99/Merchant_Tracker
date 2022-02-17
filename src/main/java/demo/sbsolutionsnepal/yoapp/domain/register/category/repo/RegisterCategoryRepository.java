package demo.sbsolutionsnepal.yoapp.domain.register.category.repo;

import demo.sbsolutionsnepal.yoapp.domain.register.category.entity.RegisterCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Himal Rai on 2/17/2022
 * SB Solutions Pvt.Ltd
 */
@Repository
public interface RegisterCategoryRepository extends JpaRepository<RegisterCategory, Long> {

}
