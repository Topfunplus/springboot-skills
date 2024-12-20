package com.example.demo;

import com.example.demo.exp_eight.Address;
import com.example.demo.exp_eight.Family;
import com.example.demo.exp_eight.PersonRepository;
import com.example.demo.exp_five.Exp6Service;
import com.example.demo.exp_five.User;
import com.example.demo.exp_seven.domain.Discuss;
import com.example.demo.exp_seven.repository.DiscussRepository;
import com.example.demo.exp_six.domain.Article;
import com.example.demo.exp_six.domain.Comment;
import com.example.demo.exp_six.mapper.ArticleMapper;
import com.example.demo.exp_six.mapper.CommentMapper;
import com.example.demo.exp_eight.Person;
import com.example.demo.exp_two.domain.Pet;
import com.example.demo.utils.JsonFormatter;
import org.hibernate.type.descriptor.jdbc.JdbcTypeFamilyInformation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    @Nested
    class Exp7_Test {
        @Autowired
        private DiscussRepository repository;

        @Test
        public void selectComment() {
            Optional<Discuss> optional = repository.findById(1);
            if (optional.isPresent()) {
                System.out.println(optional.get());
            }
            System.out.println();
        }

        // 2、使用方法名关键字进行数据操作
        @Test
        public void selectCommentByKeys() {
            List<Discuss> list = repository.findByAuthorNotNull();
            System.out.println(list);
        }

        // 3、使用@Query注解进行数据操作
        @Test
        public void selectCommentPaged() {
            Pageable pageable = PageRequest.of(0, 3);
            List<Discuss> allPaged = repository.getDiscussPaged(1, pageable);
            System.out.println(allPaged);
        }

        //  4、使用Example封装参数进行数据查询操作
        @Test
        public void selectCommentByExample() {
            Discuss discuss = new Discuss();
            discuss.setAuthor("张三");
            Example<Discuss> example = Example.of(discuss);
            List<Discuss> list = repository.findAll(example);
            System.out.println(list);
        }
    }

    @Nested
    class Exp8_Test {

        @Autowired
        private PersonRepository repository;

        @Test
        public void savePerson() {
            Person person = new Person("有才", "张", new Family("china", "topfun"), new Address("北京", "中国"));
            Person person1 = new Person("有才", "张", new Family("china", "topfun"), new Address("北京", "中国"));
            Person save1 = repository.save(person);
            Person save2 = repository.save(person1);
            System.out.println(save1);
            System.out.println(save2);
        }

        @Test
        public void selectPerson() {
            List<Person> list = repository.findByAddress_City("北京");
            System.out.println(list);
        }

//        @Test
//        public void updatePerson() {
//            Person person = repository.findByFirstnameAndLastname("张", "有才").get(0);
//            person.setName("小明");
//            Person update = repository.save(person);
//            System.out.println(update);
//        }
//
//        @Test
//        public void deletePerson() {
//            Person person = repository.findByFirstnameAndLastname("张", "小明").get(0);
//            repository.delete(person);
//        }
    }

}
