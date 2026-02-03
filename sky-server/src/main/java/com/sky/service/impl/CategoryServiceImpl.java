package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.sky.constant.StatusConstant;
import com.sky.context.BaseContext;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.mapper.CategoryMapper;
import com.sky.result.PageResult;
import com.sky.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    public void add(CategoryDTO categoryDTO){
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO,category);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        category.setCreateUser(BaseContext.getCurrentId());
        category.setUpdateUser(BaseContext.getCurrentId());
        category.setStatus(StatusConstant.DISABLE);
        categoryMapper.add(category);
    }

    public void delete(Long id){
        categoryMapper.delete(id);
    }

    public PageResult page(CategoryPageQueryDTO categoryPageQueryDTO){
        Page<Category> categoryPage = categoryMapper.page(categoryPageQueryDTO);
        Long total = categoryPage.getTotal();
        List<Category> records = categoryPage.getResult();
        return new PageResult(total,records);
    }

    public void update(CategoryDTO categoryDTO){
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO,category);
        category.setUpdateTime(LocalDateTime.now());
        category.setUpdateUser(BaseContext.getCurrentId());
        categoryMapper.update(category);
    }

    public void startOrstop(Integer status, Long id)
    {
        Category category=Category.builder().id(id).status(status).build();
        categoryMapper.update(category);

    }


}
