package com.naresh.service;

import java.util.List;

import com.naresh.entity.Player;
import com.naresh.exception.ExcelFileCreationException;


public interface ExcelFileService {
	public void createExcelFile(List<Player> players) throws ExcelFileCreationException;
}
