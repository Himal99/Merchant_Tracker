package demo.sbsolutionsnepal.yoapp.domain.register.repo;

import demo.sbsolutionsnepal.yoapp.domain.register.dto.RegisteredMerchantDto;
import demo.sbsolutionsnepal.yoapp.domain.register.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Himal Rai on 2/16/2022
 * SB Solutions Pvt.Ltd
 */
@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {

    @Query(value = "SELECT t.id,t.merchant_name ," +
            " t.bank_name,t.account_number," +
            "t.phone_number, t.city, ( 3959 * acos( cos( radians(27.717245) ) * cos( radians(t.latitude ) ) *" +
            "cos( radians(t.longitude ) - radians(85.323959) ) + sin( radians(27.717245) ) *" +
            "sin( radians(t.latitude ) ) ) ) as distance  FROM tbl_register t  order by distance  asc", nativeQuery = true)
    List<RegisteredMerchantDto> registeredMerchantByNearestLocation();
}
