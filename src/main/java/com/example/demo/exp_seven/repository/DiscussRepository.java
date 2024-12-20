package com.example.demo.exp_seven.repository;

import com.example.demo.exp_seven.domain.Discuss;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface DiscussRepository extends JpaRepository<Discuss, Integer> {

    List<Discuss> findByAuthorNotNull();

    @Query(value = "select c from t_comment c where c.aId = ?1")
    List<Discuss> getDiscussPaged(Integer aid, Pageable pageable);

    @Query(value = "select * from t_comment where a_id = ?1", nativeQuery = true)
    List<Discuss> getDiscussPaged2(Integer aid, Pageable pageable);

    @Modifying
    @Query(value = "update t_comment c set c.author = ?1 where c.id = ?2", nativeQuery = true)
    @Transactional
    int updateAuthor(String author, Integer id);
}
