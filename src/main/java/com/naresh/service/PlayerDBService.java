package com.naresh.service;

import java.util.List;

import com.naresh.entity.Player;

public interface PlayerDBService {
	public boolean savePlayers(List<String> jsonList, List<String> xmlList);

	public List<Player> FindAllPlayers();
}
