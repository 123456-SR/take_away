package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CategoryMapper {

    @Insert(value = "insert into category(id, type, name, sort, status, create_time, update_time, create_user, update_user) "+"values "
    +"(#{id},#{type},#{name},#{sort},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void add(Category category);

    @Delete("delete from category where id = #{id}")
    void delete(Long id);

    Page<Category> page(CategoryPageQueryDTO categoryPageQueryDTO);

    void update(Category category);
}
