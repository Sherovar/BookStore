package kz.everset.bookStore.service;

import kz.everset.bookStore.domain.Category;
import kz.everset.bookStore.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategorys();
    Category getCategory(Long id);
    Category addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(Long id);
}
