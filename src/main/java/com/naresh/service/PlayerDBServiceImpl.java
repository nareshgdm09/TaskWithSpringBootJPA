package com.naresh.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naresh.common.CommonUtil;
import com.naresh.entity.Player;
import com.naresh.exception.ErrorFileException;
import com.naresh.repository.PlayerRepository;

@Component
public class PlayerDBServiceImpl implements PlayerDBService {
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	FileDirectoryService fileDirectoryService;
	@Autowired
	ExcelFileService excelFileService;

	@Override
	public List<Object> savePlayers(List<String> jsonList, List<String> xmlList) {

		List<Player> players = new ArrayList<>();
		List<String> ErrorRecords = new ArrayList<>();

		jsonList.forEach(jsonString -> {
			try {
				players.add(CommonUtil.FileToObject(jsonString));
			} catch (ErrorFileException e1) {
				ErrorRecords.add(jsonString);

			}
		});

		playerRepository.saveAll(players);

		List<Object> records = new ArrayList<>();
		records.add(players);
		records.add(ErrorRecords);

		return records;

	}

	@Override
	public List<Player> FindAllPlayers() {

		return (List<Player>) playerRepository.findAll();
	}

}
