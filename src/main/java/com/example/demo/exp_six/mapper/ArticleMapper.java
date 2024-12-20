package com.example.demo.exp_six.mapper;


import com.example.demo.exp_six.domain.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleMapper {


    Article selectArticleById(int id);

    int updateArticle(Article article);

    List<Article> selectArticle(int id);
}
