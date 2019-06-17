package com.naresh.service;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import com.naresh.common.CommonUtil;
import com.naresh.common.Constants;
import com.naresh.entity.Player;
import com.naresh.exception.FileMoveException;

@Component
public class FileDirectoryServiceImpl implements FileDirectoryService {
	@Override
	public List<String> getTypeFiles(String dirPath, String fileType) {
		List<String> listFiles = new ArrayList<>();
		File directory = new File(dirPath);
		File[] jsonFiles = directory.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(fileType);
			}
		});
		Arrays.stream(jsonFiles).forEach(file -> listFiles.add(CommonUtil.removeFileExt(file)));
		return listFiles;
	}

	@Override
	public void moveCompletedFiles(List<Player> playerRecords) {
		for (Player player : playerRecords) {
			
			try {
				FileUtils.moveFile(FileUtils.getFile(Constants.JSONPATH + player.getId() + Constants.JSONEXT),
						FileUtils.getFile(Constants.JSONCOMPLTEDPATH + player.getId() + Constants.JSONEXT));
				FileUtils.moveFile(FileUtils.getFile(Constants.XMLPATH + player.getId() + Constants.XMLEXT),
						FileUtils.getFile(Constants.XMLCOMPLETEDPATH + player.getId() + Constants.XMLEXT));

			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw new FileMoveException("File Not found");
			}
		}
	}
}
