package com.example.demo.exp_six.mapper;


import com.example.demo.exp_six.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
// 对comment 进行增删改查
public interface CommentMapper {

    @Select("select * from t_comment where id = #{id}")
    public Comment findById(Integer id);


    @Select("insert into t_comment values(#{id},#{content},#{author},#{aId})")
    public void insertComment(Comment comment);


    @Select("update t_comment set content=#{content} where id=#{id}")
    public void updateComment(Comment comment);

    @Select("delete from t_comment where id=#{id}")
    public void deleteComment(Integer id);
}
