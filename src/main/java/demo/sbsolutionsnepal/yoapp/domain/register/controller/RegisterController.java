package demo.sbsolutionsnepal.yoapp.domain.register.controller;

import demo.sbsolutionsnepal.yoapp.base.baseDomain.BaseController;
import demo.sbsolutionsnepal.yoapp.domain.register.dto.RegisteredMerchantDto;
import demo.sbsolutionsnepal.yoapp.domain.register.entity.Register;
import demo.sbsolutionsnepal.yoapp.domain.register.service.RegisterServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

import static demo.sbsolutionsnepal.yoapp.base.apiUrl.Url.*;

/**
 * @author Himal Rai on 2/16/2022
 * SB Solutions Pvt.Ltd
 */
@Controller
@RequestMapping(REGISTER)
public class RegisterController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(RegisterController.class);

    private final RegisterServiceImpl registerService;
    private final HttpSession httpSession;

    RegisterController(RegisterServiceImpl registerService, HttpSession httpSession){
        this.registerService = registerService;
        this.httpSession = httpSession;
        viewPath="register";
    }

    @GetMapping
    public String index(Model model){
        return viewPath + INDEX;
    }

    @PostMapping(SAVE)
    @ResponseBody
    public String save(@ModelAttribute  Register register, Model model){
        logger.info("register::{}", register);
         registerService.save(register);
         return "success";
    }

    @GetMapping(JSON)
    @ResponseBody
    public List<RegisteredMerchantDto> getJson(){
        Register registeredUser = (Register) httpSession.getAttribute("currentLocation");
        if(!ObjectUtils.isEmpty(registeredUser))
            return registerService.registeredMerchantDtos(registeredUser.getLatitude(),registeredUser.getLongitude());

        return registerService.registeredMerchantDtos(0.0,0.0);
    }
}
