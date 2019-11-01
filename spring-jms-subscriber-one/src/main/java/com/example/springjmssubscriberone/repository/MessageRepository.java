package com.example.springjmssubscriberone.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springjmssubscriberone.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {

}
