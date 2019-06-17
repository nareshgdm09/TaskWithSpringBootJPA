package com.naresh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.naresh.entity.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
}