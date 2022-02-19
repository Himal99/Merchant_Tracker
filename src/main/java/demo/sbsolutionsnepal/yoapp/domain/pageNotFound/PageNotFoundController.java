package demo.sbsolutionsnepal.yoapp.domain.pageNotFound;

import demo.sbsolutionsnepal.yoapp.base.SiteController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static demo.sbsolutionsnepal.yoapp.base.apiUrl.Url.INDEX;
import static demo.sbsolutionsnepal.yoapp.base.apiUrl.Url.PAGE_NOT_FOUND;

/**
 * @author Himal Rai on 2/16/2022
 * SB Solutions Pvt.Ltd
 */
@Controller
@RequestMapping(PAGE_NOT_FOUND)
@Api(tags = "Page Not Found")
public class PageNotFoundController extends SiteController {


    public PageNotFoundController() {
        viewPath = "errorPage";
    }

    @GetMapping
    @ApiOperation(value = "Page Not Found", tags = "Page Not Found")
    public String index() {
        return viewPath.concat(INDEX);
    }
}
