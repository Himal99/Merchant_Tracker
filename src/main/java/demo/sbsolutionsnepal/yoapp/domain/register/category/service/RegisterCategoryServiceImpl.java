package demo.sbsolutionsnepal.yoapp.domain.register.category.service;

import demo.sbsolutionsnepal.yoapp.domain.register.category.entity.RegisterCategory;
import demo.sbsolutionsnepal.yoapp.domain.register.category.repo.RegisterCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Himal Rai on 2/17/2022
 * SB Solutions Pvt.Ltd
 */
@Service
public class RegisterCategoryServiceImpl implements RegisterCategoryService {

    private final RegisterCategoryRepository repository;

    public RegisterCategoryServiceImpl(RegisterCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public RegisterCategory save(RegisterCategory registerCategory) {
        return repository.save(registerCategory);
    }

    @Override
    public List<RegisterCategory> getAll() {
        return repository.findAll();
    }

    @Override
    public RegisterCategory findOne(Long id) {
        return repository.getById(id);
    }

    @Override
    public void saveAll(List<RegisterCategory> registerCategories) {
repository.saveAll(registerCategories);
    }
}
