package com.back.Repos;

import com.back.Entities.Chating.ChatMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMemberRepo extends JpaRepository<ChatMember,Long> {
}
