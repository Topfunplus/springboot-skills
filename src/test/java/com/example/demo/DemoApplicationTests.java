package com.example.demo;

import com.example.demo.exp_five.Exp6Service;
import com.example.demo.exp_five.User;
import com.example.demo.exp_six.domain.Article;
import com.example.demo.exp_six.domain.Comment;
import com.example.demo.exp_six.mapper.ArticleMapper;
import com.example.demo.exp_six.mapper.CommentMapper;
import com.example.demo.exp_two.domain.Person;
import com.example.demo.exp_two.domain.Pet;
import com.example.demo.utils.JsonFormatter;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Nested
    class Exp4_Test {

        @Autowired
        private Person person;

        @Autowired
        private Pet pet;

        @Test
        void exp_three_test() {
            /*
             * Person{type='student', name='John Doe'}
             * Pet{name='Tom', type='cat', friends=[Jerry, Spike], hobbies=[running, sleeping], score={english=90, math=80, science=70},
             * category=Category{name='husky', type='null'}}
             */
            System.out.println(person.toString());
            System.out.println(pet.toString());
        }
    }

    @Nested
    class Exp5_Test {

        @Autowired
        private User user;

        @Autowired
        private Exp6Service exp6Service;

        @Test
        void exp_five_test() {
            System.out.println(user.toString());
            exp6Service.getServiceId("1008611");
        }
    }

    @Nested
    class Exp6_Test {

        @Autowired
        private CommentMapper commentMapper;

        @Autowired
        private ArticleMapper articleMapper;

        @Test
        void exp_six_test_select() {
            System.out.println("测试查询");
            Comment comment = commentMapper.findById(1);
            System.out.println(comment.toString());
        }

        @Test
        void exp_six_test_insert() {
            System.out.println("测试插入");
            Comment comment = new Comment();
            comment.setId(10);
            comment.setaId(4);
            comment.setAuthor("我自己");
            comment.setContent("真不错");
            try {
                commentMapper.insertComment(comment);
            } catch (Exception e) {
                System.out.println("插入失败:" + e.getMessage());
            }
        }

        @Test
        void exp_six_test_update() {
            System.out.println("测试更新");
            Comment comment = new Comment();
            comment.setId(10);
            comment.setaId(4);
            comment.setAuthor("我自己");
            comment.setContent("真不错123");
            try {
                commentMapper.updateComment(comment);
            } catch (Exception e) {
                System.out.println("更新失败:" + e.getMessage());
            }
        }

        @Test
        void exp_six_test_delete() {
            System.out.println("测试删除");
            try {
                commentMapper.deleteComment(10);
            } catch (Exception e) {
                System.out.println("删除失败:" + e.getMessage());
            }
        }

        @Test
        @Transactional
        void exp_six_test_mapper_select() {
            try {
                System.out.println("测试查询1");
                Article article = articleMapper.selectArticleById(1);
                System.out.println(article.toString());

                System.out.println("----------------------");
                System.out.println("测试查询2");
                List<Article> myArticleList = articleMapper.selectArticle(1);

                Object formattedList = JsonFormatter.formatter(myArticleList);
                System.out.println("格式化后的魅力输出:" + formattedList);
            } catch (Exception e) {
                System.out.println("查询失败:" + e.getMessage());
            }
        }
    }

}
