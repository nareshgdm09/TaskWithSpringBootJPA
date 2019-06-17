package com.naresh.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.naresh.common.CommonUtil;
import com.naresh.common.Constants;
import com.naresh.entity.Player;
import com.naresh.service.FileDirectoryService;
import com.naresh.service.PlayerDBService;

@Component
public class ModelTrainer {
	// private static final Logger logger =
	// LogManager.getLogger(ModelTrainer.class);

	@Autowired
	FileDirectoryService fileDirectoryService;

	@Autowired
	PlayerDBService PlayerDBService;

	@Scheduled(initialDelay = 1000, fixedRate = 3000)
	public void modelTrainerscheduledMethod() {

		List<String> jsonFiles = fileDirectoryService.getTypeFiles(Constants.JSONPATH, Constants.JSONEXT);
		List<String> xmlFiles = fileDirectoryService.getTypeFiles(Constants.XMLPATH, Constants.XMLEXT);

		if (jsonFiles.size() > 0 && xmlFiles.size() > 0) {
			CommonUtil.findCommonFiles(jsonFiles, xmlFiles);

			PlayerDBService.savePlayers(jsonFiles, xmlFiles);

			List<Player> players = PlayerDBService.FindAllPlayers();
		}
	}

	public void test() {
		System.out.println("printing from test methos");
	}
}
