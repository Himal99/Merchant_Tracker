package demo.sbsolutionsnepal.yoapp.domain.merchantProfile.controller;

import demo.sbsolutionsnepal.yoapp.base.SiteController;
import demo.sbsolutionsnepal.yoapp.domain.register.entity.Register;
import demo.sbsolutionsnepal.yoapp.domain.register.service.RegisterServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import static demo.sbsolutionsnepal.yoapp.base.apiUrl.Url.*;

/**
 * @author Himal Rai on 2/18/2022
 * SB Solutions Pvt.Ltd
 */

@Controller
@RequestMapping(MERCHANT_PROFILE)
public class MerchantProfileController extends SiteController {

    private final RegisterServiceImpl registerService;

    public MerchantProfileController(RegisterServiceImpl registerService){
        this.registerService = registerService;
        pageTitle="Profile";
        viewPath="merchantProfile";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView profile(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewPath.concat(INDEX));
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = GET_BY_ID)
    @ResponseBody
    public Register getMerchantProfileById(@PathVariable("id") Long id){

        return registerService.getById(id);
    }
}
