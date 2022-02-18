package demo.sbsolutionsnepal.yoapp;

import demo.sbsolutionsnepal.yoapp.domain.register.category.entity.RegisterCategory;
import demo.sbsolutionsnepal.yoapp.domain.register.category.repo.RegisterCategoryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

import static demo.sbsolutionsnepal.yoapp.base.dbPath.DbPath.REGISTER_CATEGORY;

@SpringBootApplication(scanBasePackages = "demo.sbsolutionsnepal.yoapp")
public class SbsolutionsnepalYoappApplication extends SpringBootServletInitializer {

    private final DataSource dataSource;
    private final RegisterCategoryRepository service;

    public SbsolutionsnepalYoappApplication(DataSource dataSource,
                                            RegisterCategoryRepository service) {
        this.dataSource = dataSource;
        this.service = service;
    }

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(SbsolutionsnepalYoappApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SbsolutionsnepalYoappApplication.class, args);

    }


    @EventListener(ApplicationReadyEvent.class)
    public void initialize() {
        ResourceDatabasePopulator populator
                = new ResourceDatabasePopulator(false,
                false, "UTF-8", new ClassPathResource(REGISTER_CATEGORY));
        List<RegisterCategory> categoryList = service.findAll();
        if (categoryList.isEmpty()) {
            populator.execute(dataSource);
        }
    }

    @PostConstruct
    public void loadSql() throws Exception {

    }



}
