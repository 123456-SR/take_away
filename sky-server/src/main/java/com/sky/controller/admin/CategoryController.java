package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;

import com.sky.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.sky.result.Result.success;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @ApiOperation("新增分类")
     public Result add(@RequestBody CategoryDTO categoryDTO){
        categoryService.add(categoryDTO);
        return  success();
    }

    @DeleteMapping
    @ApiOperation("根据id删除")
    public Result delete(Long id){
        categoryService.delete(id);
        return  success();
    }

    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public Result<PageResult> page( CategoryPageQueryDTO categoryPageQueryDTO){
        PageResult pages=categoryService.page(categoryPageQueryDTO);
        return Result.success(pages);
    }

    @PutMapping
    @ApiOperation("修改分类")
    public Result update(@RequestBody CategoryDTO categoryDTO){
        categoryService.update(categoryDTO);
        return  success();
    }

    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用分类")
    public Result updateStatus(@PathVariable("status") Integer status,Long id ){

        categoryService.startOrstop(status,id);
        return  Result.success();
    }
}
