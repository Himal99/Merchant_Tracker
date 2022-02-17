package demo.sbsolutionsnepal.yoapp.domain.payment.controller;

import demo.sbsolutionsnepal.yoapp.base.SiteController;
import demo.sbsolutionsnepal.yoapp.domain.register.dto.RegisteredMerchantDto;
import demo.sbsolutionsnepal.yoapp.domain.register.entity.Register;
import demo.sbsolutionsnepal.yoapp.domain.register.service.RegisterServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static demo.sbsolutionsnepal.yoapp.base.apiUrl.Url.INDEX;
import static demo.sbsolutionsnepal.yoapp.base.apiUrl.Url.PAYMENT;

/**
 * @author Himal Rai on 2/16/2022
 * SB Solutions Pvt.Ltd
 */
@Controller
@RequestMapping(PAYMENT)
public class PaymentController extends SiteController {

    private Logger logger = LoggerFactory.getLogger(PaymentController.class);
    private final RegisterServiceImpl registerService;
    private final HttpSession session;

    PaymentController(RegisterServiceImpl registerService, HttpSession session) {
        this.registerService = registerService;
        this.session = session;
        viewPath = "payment";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(value = "latitude", required = false, defaultValue = "0") double lalitude,
                              @RequestParam(value = "longitude", required = false, defaultValue = "0") double longitude) {
        logger.info("Request Value::{}", lalitude);
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName(viewPath.concat(INDEX));
        RegisteredMerchantDto registeredMerchantDto ;
        if (lalitude == 0.0 && longitude == 0.0) {
            modelAndView.addObject("data", new RegisteredMerchantDto());
            return modelAndView;
        }
        registeredMerchantDto = registerService.registeredMerchantDtos(lalitude, longitude).get(0);
        modelAndView.addObject("data", registeredMerchantDto);
        List<RegisteredMerchantDto> registeredMerchantDtoList = new ArrayList<>();
        for (int i=1;i<registerService.registeredMerchantDtos(lalitude, longitude).size();i++){
            registeredMerchantDtoList.add(registerService.registeredMerchantDtos(lalitude, longitude).get(i));
        }
        modelAndView.addObject("datas", registeredMerchantDtoList);
        setCurrentLocation(lalitude, longitude);
        return modelAndView;
    }



    private void setCurrentLocation(Double latitude, Double longitude){
        Register register= new Register();
        register.setLatitude(latitude);
        register.setLongitude(longitude);
        session.setAttribute("currentLocation", register);
    }


}
