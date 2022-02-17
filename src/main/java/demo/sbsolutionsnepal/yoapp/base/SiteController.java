package demo.sbsolutionsnepal.yoapp.base;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author Himal Rai on 2/16/2022
 * SB Solutions Pvt.Ltd
 */

@Getter
@Setter
@Data
public abstract class SiteController {
    protected String pageURI,viewPath,pageTitle;

    @ModelAttribute()
    public void globalVariable(Model model){
        model.addAttribute("pagerURI", pageURI);
        model.addAttribute("viewPath", viewPath);
        model.addAttribute("pageTitle", pageTitle);
    }
}
