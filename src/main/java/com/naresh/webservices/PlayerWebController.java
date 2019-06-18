package com.naresh.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.entity.Player;
import com.naresh.service.PlayerWebService;

@RestController
public class PlayerWebController {
	@Autowired
	PlayerWebService playerWebService;

	@PostMapping(path = "/players", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Player> playerRestservice(@RequestBody Player player) {
		return playerWebService.findPlayer(player);

	}
}