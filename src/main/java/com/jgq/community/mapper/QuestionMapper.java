package com.jgq.community.mapper;

import com.jgq.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author JiGuoqing
 * @date 2019/10/31 10:00
 */
@Mapper
public interface QuestionMapper {
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    Integer createQuestion(Question question);
    @Select("select * from question limit #{offset},#{size}")
    List<Question> getAllByPage(@Param("offset")Integer offset,@Param("size")Integer size);
    @Select("select count(1) from question")
    Integer getCount();
}
