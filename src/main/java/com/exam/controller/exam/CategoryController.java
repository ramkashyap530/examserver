package com.exam.controller.exam;

import com.exam.model.exam.Category;
import com.exam.service.exam.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //Add Category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category)
    {
        return ResponseEntity.ok(this.categoryService.addCategory(category));
    }

    // getCategory
    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable("categoryId") Long categoryId)
    {
        return ResponseEntity.ok(this.categoryService.getCategory(categoryId));
    }

    // getCategories
    @GetMapping("/")
    public ResponseEntity<?> getCategories()
    {return ResponseEntity.ok(this.categoryService.getCategories());}


    //Update Category
    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category)
    {return this.categoryService.updateCategory(category);}

    //Delete Category
    @DeleteMapping("/{categoryId}")
    public void deleteCategory (@PathVariable("categoryId") Long categoryId)
    {this.categoryService.deleteCategory(categoryId);}


}
