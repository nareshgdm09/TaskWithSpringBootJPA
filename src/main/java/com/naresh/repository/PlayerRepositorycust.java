package com.naresh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naresh.entity.Player;

interface PlayerRepositorycust extends JpaRepository<Player, Long>, PlayerRepositoryCustom {
}