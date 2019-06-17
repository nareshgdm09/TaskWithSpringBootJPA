package com.naresh.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.naresh.entity.Player;
@Repository
public interface PlayerRepositoryCustom {
	List<Player> findAll(Player player);
}