package com.naresh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.entity.Player;
import com.naresh.repository.PlayerRepositoryCustom;

@Service
public class PlayerWebServiceImpl implements PlayerWebService {
	@Autowired
	private PlayerRepositoryCustom playerRepositorycust;

	public List<Player> findPlayer(Player player) {

		List<Player> players = (List<Player>) playerRepositorycust.findAll(player);
		return players;
	}

}
