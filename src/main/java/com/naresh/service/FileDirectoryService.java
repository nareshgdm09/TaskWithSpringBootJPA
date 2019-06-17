package com.naresh.service;

import java.util.List;

import com.naresh.entity.Player;

public interface FileDirectoryService {

	List<String> getTypeFiles(String dirPath, String fileType);

	void moveCompletedFiles(List<Player> playerRecords);
}
