package com.song.books.dao;

import com.song.books.entity.BooksUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<BooksUser,String> {
    @Query("select t from BooksUser t where t.userName = :username and t.passWord= :password")
    BooksUser selectUser(String username, String password);

    @Query("update BooksUser u set u.passWord = :password where u.id=:userId")
    @Modifying
    void updateUser(String password,String userId);
}
