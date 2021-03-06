package com.example.bookstore.services;

import com.example.bookstore.dao.CategoryRepository;
import com.example.bookstore.models.Category;
import com.example.bookstore.utilities.RegexTests;
import com.example.bookstore.views.ICategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    private final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Override
    public List<Category> retrieveAllCategories() {
        List<Category> categories = new ArrayList<Category>();
        categoryRepository.findAll().forEach(categories::add);
        logger.info("retrieved list of categories"+categories);
        return categories;
    }

    @Override
    public TreeMap<String, String> retrieveCategoriesToTreeMAp() {
        TreeMap<String, String>  treemap= new TreeMap<String,String>((c1,c2)->c1.compareTo(c2));
        for (Category category: retrieveAllCategories())
        {
            treemap.put(category.getName(), category.getDescription());
        }
        logger.info("retrieved list of categories"+treemap);
        return treemap;
    }

    @Override
    public Category addCategory(Category category) {
        if ((RegexTests.isAvalidCategory(category.getName()))) {
            logger.info("Adding Category " + category);
            return categoryRepository.save(category);
        }
        else
        {
           logger.warn("Invalid category name: " + category.getName());
            return null;

        }

    }

    @Override
    public void deleteCategory(String id) {
        Optional<Category> cat= categoryRepository.findById(Long.parseLong(id));
        categoryRepository.delete(cat.get());
    }

    @Override
    public Category updateCategory(Category u) {
        return null;

    }

    @Override
    public Category retrieveCategoryById(String id) {
        Optional<Category> cat= categoryRepository.findById(Long.parseLong(id));
        if (cat.get() ==null)
            logger.error("category with id "+id+" doesn't exist");
        else logger.info("Retrieved category "+cat.get());
        return cat.get();
    }

    @Override
    public List<Category> retrieveCategoryByName(String name) {

       List<Category> cat = this.retrieveAllCategories().stream()
               .filter(c->c.getName().toUpperCase().contains(name.toUpperCase()))
               .collect(Collectors.toList());
       if (cat==null)
           logger.warn("couldn't find any categories with the name: "+ name);
       else
           logger.info("retrieved categories: "+cat);
       return cat;

    }

    @Override
    public boolean categoryNameDoesntExist(String name) {
        return this.retrieveAllCategories().stream()
                .map(c->c.getName().toUpperCase())
                .noneMatch(c->c.equals(name.toUpperCase()));
    }

}
