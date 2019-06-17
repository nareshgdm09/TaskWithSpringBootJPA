package com.naresh.service;

import java.util.List;

import com.naresh.entity.Player;

public interface PlayerWebService {
	public List<Player> findPlayer(Player player);
}
