package demo.sbsolutionsnepal.yoapp.domain.register.service;

import demo.sbsolutionsnepal.yoapp.domain.register.dto.RegisteredMerchantDto;
import demo.sbsolutionsnepal.yoapp.domain.register.entity.Register;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Himal Rai on 2/16/2022
 * SB Solutions Pvt.Ltd
 */
@Service
public interface RegisterService {
    List<RegisteredMerchantDto> registeredMerchantDtos(Double latitude, Double longitude);

    List<Register> getAll();

    void save(Register register);
}
