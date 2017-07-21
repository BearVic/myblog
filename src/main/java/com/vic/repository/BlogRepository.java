package com.vic.repository;

import com.vic.model.BlogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by victor on 14/07/2017.
 */

@Repository
public interface BlogRepository extends JpaRepository<BlogsEntity, Integer> {


    @Query(value = "select * from blogs b where b.title=?1", nativeQuery = true)
    BlogsEntity findByBlogTitle(String title);

    @Query(value = "select title from blogs LIMIT ?1,?2", nativeQuery = true)
    List<String> findByBlogLimit(int param1, int param2);

    @Query(value = "select count(*) from blogs", nativeQuery = true)
    int findBlogNum();

//    @Query(value = "delete from blogs b where b.title=?1", nativeQuery = true)
//    boolean deleteByBlogTitle(String title);

    @Modifying
    @Transactional
    @Query(value = "delete from blogs where title=?1", nativeQuery = true)
    void deleteByBlogTitle(String title);
}
