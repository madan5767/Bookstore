package com.example.bookstore.views;

import com.example.bookstore.models.Category;

import java.util.List;
import java.util.TreeMap;

public interface ICategoryService {

    List<Category> retrieveAllCategories();
    Category addCategory(Category u);
    void deleteCategory(String id);
    Category updateCategory(Category u);
    Category retrieveCategoryById(String id);
    List<Category> retrieveCategoryByName(String name);
    boolean categoryNameDoesntExist(String name);
    public TreeMap<String, String> retrieveCategoriesToTreeMAp();
}
