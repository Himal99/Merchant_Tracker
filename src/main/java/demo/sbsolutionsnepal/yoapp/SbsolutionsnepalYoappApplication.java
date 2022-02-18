package demo.sbsolutionsnepal.yoapp;

import demo.sbsolutionsnepal.yoapp.domain.register.category.repo.RegisterCategoryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@SpringBootApplication(scanBasePackages = "demo.sbsolutionsnepal.yoapp")
public class SbsolutionsnepalYoappApplication {

    private final DataSource dataSource;
    private final RegisterCategoryRepository service;

    public SbsolutionsnepalYoappApplication(DataSource dataSource,
                                            RegisterCategoryRepository service) {
        this.dataSource = dataSource;
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(SbsolutionsnepalYoappApplication.class, args);

    }


    @EventListener(ApplicationReadyEvent.class)
    public void initialize() {
        ResourceDatabasePopulator populator
                = new ResourceDatabasePopulator(false,
                false, "UTF-8", new ClassPathResource("dbSql/category.sql"));
        populator.execute(dataSource);
    }

    @PostConstruct
    public void loadSql() throws Exception {

    }

}
