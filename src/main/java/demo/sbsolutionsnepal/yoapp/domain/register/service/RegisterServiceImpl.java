package demo.sbsolutionsnepal.yoapp.domain.register.service;

import demo.sbsolutionsnepal.yoapp.domain.register.category.repo.RegisterCategoryRepository;
import demo.sbsolutionsnepal.yoapp.domain.register.dto.RegisteredMerchantDto;
import demo.sbsolutionsnepal.yoapp.domain.register.entity.Register;
import demo.sbsolutionsnepal.yoapp.domain.register.repo.RegisterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Himal Rai on 2/16/2022
 * SB Solutions Pvt.Ltd
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    private final Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);


    private final RegisterRepository registerRepository;
    private final EntityManager em;
    private final HttpSession httpSession;
    private final RegisterCategoryRepository categoryRepository;

    @Autowired
    public RegisterServiceImpl(RegisterRepository registerRepository, EntityManager em, HttpSession httpSession, RegisterCategoryRepository categoryRepository) {
        this.registerRepository = registerRepository;
        this.em = em;
        this.httpSession = httpSession;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<RegisteredMerchantDto> registeredMerchantDtos(Double latitude, Double longitude) {
        List<RegisteredMerchantDto> objectList = this.em.createNativeQuery("SELECT TOP 4 id,merchant_name ," +
                        " bank_name,account_number," +
                        "phone_number, city,brand_name, ( 3959 * acos( cos(radians(?1)) * cos(radians(t.latitude)) *" +
                        "cos( radians(t.longitude ) -  radians(?2) ) + sin(radians(?3)) *" +
                        "sin( radians(t.latitude ) ) ) ) as distance  FROM tbl_register t  order by distance asc", "RegisteredMerchantDtoMapping").setParameter(1, latitude).
                setParameter(2, longitude).setParameter(3, latitude)
                .getResultList();

        // Currently, it is calculating the distance in miles, replace the number '3959' with '6371' to get distance in KM.

        return objectList;
    }

    @Override
    public List<Register> getAll() {
        List<Register> registerList = registerRepository.findAll();
        return registerList;
    }

    @Override
    public void save(Register register) {
        registerRepository.save(register);
    }
}
