package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;


public interface CategoryService {

    void add(CategoryDTO categoryDTO);


    void delete(Long id);

    PageResult page(CategoryPageQueryDTO categoryDTO);

    void update(CategoryDTO categoryDTO);

    void startOrstop(Integer status, Long id);
}
