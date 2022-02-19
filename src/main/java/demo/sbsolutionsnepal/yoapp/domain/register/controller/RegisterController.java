package demo.sbsolutionsnepal.yoapp.domain.register.controller;

import demo.sbsolutionsnepal.yoapp.base.baseDomain.BaseController;
import demo.sbsolutionsnepal.yoapp.domain.register.category.repo.RegisterCategoryRepository;
import demo.sbsolutionsnepal.yoapp.domain.register.dto.RegisteredMerchantDto;
import demo.sbsolutionsnepal.yoapp.domain.register.entity.Register;
import demo.sbsolutionsnepal.yoapp.domain.register.service.RegisterServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpSession;
import java.util.List;

import static demo.sbsolutionsnepal.yoapp.base.apiUrl.Url.*;

/**
 * @author Himal Rai on 2/16/2022
 * SB Solutions Pvt.Ltd
 */
@Controller
@RequestMapping(REGISTER)
@Api(tags = "Merchant Register")
public class RegisterController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    private final RegisterServiceImpl registerService;
    private final HttpSession httpSession;
    private final RegisterCategoryRepository categoryRepository;

    RegisterController(RegisterServiceImpl registerService, HttpSession httpSession, RegisterCategoryRepository categoryRepository) {
        this.registerService = registerService;
        this.httpSession = httpSession;
        this.categoryRepository = categoryRepository;
        viewPath = "register";
    }

    @GetMapping@ApiOperation(value = "Registration View", tags = "Merchant Register")
    public String index(Model model) {
        model.addAttribute("category", categoryRepository.findAll());
        return viewPath.concat(INDEX);
    }

    @PostMapping(SAVE)
    @ResponseBody @ApiOperation(value = "Save Merchant Register", tags = "Merchant Register")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Invalid"),
            @ApiResponse(code = 500, message = "Internal Server Error", response = HttpServerErrorException.InternalServerError.class)
    })
    public String save(@ModelAttribute Register register, Model model) {
        logger.info("register::{}", register);
        registerService.save(register);
        return "success";
    }

    @GetMapping(JSON)
    @ResponseBody @ApiOperation(value = "Get list of top 4 nearest merchant ", tags = "Merchant Register")
    public List<RegisteredMerchantDto> getJson() {
        Register registeredUser = (Register) httpSession.getAttribute("currentLocation");
        if (!ObjectUtils.isEmpty(registeredUser))
            return registerService.registeredMerchantDtos(registeredUser.getLatitude(), registeredUser.getLongitude());

        return registerService.registeredMerchantDtos(0.0, 0.0);
    }
}
