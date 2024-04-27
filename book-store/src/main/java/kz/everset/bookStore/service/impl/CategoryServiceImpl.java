package kz.everset.bookStore.service.impl;

import kz.everset.bookStore.domain.Category;
import kz.everset.bookStore.repo.CategoryRepository;
import kz.everset.bookStore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategorys() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No such category_id"));
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        Category oldCategory = getCategory(category.getId());
        if (category.getName() != null){
            oldCategory.setName(category.getName());
        }
        if (category.getDescription() != null){
            oldCategory.setDescription(category.getDescription());
        }
        categoryRepository.save(oldCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
