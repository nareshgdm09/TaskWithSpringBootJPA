package com.naresh.service;

import java.util.ArrayList;
import java.util.List;

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
	public boolean savePlayers(List<String> jsonList, List<String> xmlList) {

		List<Player> players = new ArrayList<>();
		List<String> ErrorRecords = new ArrayList<>();

		jsonList.forEach(jsonString -> {
			try {
				players.add(CommonUtil.FileToObject(jsonString));
			} catch (ErrorFileException e1) {
				ErrorRecords.add(jsonString);
				e1.getMessage();
			}
		});

		List<Player> ErrorPlayerrecords = new ArrayList<>();
		System.out.println(ErrorRecords);

		/*
		 * for (Player player : players) { boolean idnull = player.getId() == 0; if
		 * (idnull) ErrorPlayerrecords.add(player); }
		 */

		players.removeAll(ErrorPlayerrecords);

		playerRepository.saveAll(players);

		fileDirectoryService.moveCompletedFiles(players);

		try {
			excelFileService.createExcelFile(players);
		} catch (Exception e) {
			System.out.println("Exception cahced");
		}

		return true;

	}

	@Override
	public List<Player> FindAllPlayers() {

		return (List<Player>) playerRepository.findAll();
	}

}
