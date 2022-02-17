package demo.sbsolutionsnepal.yoapp.domain.home.controller;

import demo.sbsolutionsnepal.yoapp.base.baseDomain.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static demo.sbsolutionsnepal.yoapp.base.apiUrl.Url.BASE;
import static demo.sbsolutionsnepal.yoapp.base.apiUrl.Url.INDEX;

/**
 * @author Himal Rai on 2/15/2022
 * SB Solutions Pvt.Ltd
 */
@Controller
@RequestMapping(value = BASE)
public class HomeController extends BaseController {

    HomeController() {
        viewPath = "home";
        pageTitle="Home";
        pageURI="home";
    }

    @GetMapping()
    public String index() {
        return viewPath.concat(INDEX);
    }

}
