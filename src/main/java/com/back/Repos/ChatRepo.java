package com.back.Repos;

import com.back.Entities.Chating.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ChatRepo extends JpaRepository<Chat,Long> {

    @Query(value = "insert into ",nativeQuery = true)
    public void insertMessage(Long chatId , String message , Date date);
}
