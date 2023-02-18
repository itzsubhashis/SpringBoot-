package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ConsumerEntity;

@Repository
public interface ConsumerRepo extends JpaRepository<ConsumerEntity, Integer> {
}
