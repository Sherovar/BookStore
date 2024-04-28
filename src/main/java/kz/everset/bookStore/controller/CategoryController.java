package kz.everset.bookStore.controller;

import kz.everset.bookStore.domain.Category;
import kz.everset.bookStore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategorys();
    }

    @GetMapping("/{id}")
    public Category getCategory(@RequestParam Long id){
        return categoryService.getCategory(id);
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @PutMapping("/{id}")
    public void updateCategory(@RequestBody Category category){
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@RequestParam Long id){
        categoryService.deleteCategory(id);
    }
}
