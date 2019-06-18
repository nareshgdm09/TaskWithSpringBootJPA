package com.naresh.service;

import java.util.List;

import com.naresh.entity.Player;
import com.naresh.exception.FileMoveException;

public interface FileDirectoryService {

	List<String> getTypeFiles(String dirPath, String fileType);

	void moveCompletedFiles(List<Player> playerRecords) throws FileMoveException;
	
	void moveErrorFiles(List<String> errorRecords) throws FileMoveException;
}
