//package com.naughtyzombie.boilerplate.springreactboilerplate.repository;
//
//import com.naughtyzombie.boilerplate.springreactboilerplate.model.Bookmark;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.awt.print.Book;
//import java.beans.Transient;
//import java.util.List;
//
//@Repository
//public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
//
////    @Transient
////    @Modifying
////    @Query(value = "DELETE FROM bookmark WHERE userId = :userId AND newsId = :newsId ")
////    void deleteBookmark(Long userId, Long newsId);
//
//    @Query(value = "SELECT news_id FROM bookmark WHERE user_id = :userId", nativeQuery = true)
//    List<Object[]> getAllBookmarks(@Param("userId")Long userId);
//}
package com.naughtyzombie.boilerplate.springreactboilerplate.repository;

import com.naughtyzombie.boilerplate.springreactboilerplate.model.Bookmark;
import com.naughtyzombie.boilerplate.springreactboilerplate.model.BookmarkId;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, BookmarkId> {

    @Query(value = "SELECT news_id FROM bookmark WHERE user_id = ?1", nativeQuery = true)
    List<Object[]> findByUserId(Long userId);
}
