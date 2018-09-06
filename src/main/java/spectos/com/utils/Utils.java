package spectos.com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
public class Utils {

	public static Properties loadConfig(String fileName) {
		Properties configProperties = null;

		FileInputStream in;
		try {
			in = new FileInputStream(fileName);
			configProperties = new Properties();
			configProperties.load(in);
			in.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return configProperties;
	}

	public static void pause(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static String[][] getTableObject(String xlFilePath, String sheetName) {
		String[][] tabArray = null;
		int ci, cj;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			tabArray = new String[sheet.getRows() - 1][3];
			ci = 0;

			for (int i = 1; i < sheet.getRows(); i++, ci++) {
				cj = 0;
				for (int j = 0; j < 3; j++, cj++) {
					tabArray[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (tabArray);
	}

	public static By getLocation(String ex, String typeEx) {

		By result;
		switch (typeEx) {
		case "id":
			result = By.id(ex);
			break;
		case "xpath":
			result = By.xpath(ex);
			break;
		case "linkText":
			result = By.linkText(ex);
			break;
		case "className":
			result = By.className(ex);
			break;
		case "cssSelector":
			result = By.cssSelector(ex);
			break;
		case "name":
			result = By.name(ex);
			break;
		case "partialLinkText":
			result = By.partialLinkText(ex);
			break;
		case "tagName":
			result = By.tagName(ex);
			break;
		default:
			result = null;
		}
		return result;
	}
	
	public static List<HashMap<String, String>> getTestData(String dataFile,
			String dataSheet, String tableName) {
		List<HashMap<String, String>> listData = new ArrayList<HashMap<String, String>>();
		int id = 1;

		try {
			Workbook workbook = Workbook.getWorkbook(new File(dataFile));
			Sheet sheet = workbook.getSheet(dataSheet);
			int startRow, startCol, endRow, endCol;
			Cell tableStart = sheet.findCell(tableName);
			startRow = tableStart.getRow();
			startCol = tableStart.getColumn();

			Cell tableEnd = sheet.findCell(tableName, startCol + 1,
					startRow + 1, 200, 64000, false);

			endRow = tableEnd.getRow();
			endCol = tableEnd.getColumn();

//			System.out.println("Loaded data from Excel: Row[" + startRow + ".." + endRow
//					+ "], Columns[" + startCol + ".." + endCol + "]");

			for (int i = startRow + 1; i < endRow; i++) {
				HashMap<String, String> valSet = new HashMap<String, String>();

				// Set row index
				valSet.put("ID", "" + id++);

				for (int j = 1; j < endCol; j++) {
					valSet.put(sheet.getCell(j, startRow).getContents().trim(),
							sheet.getCell(j, i).getContents().trim());

				}

				listData.add(valSet);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (listData);
	}


}
