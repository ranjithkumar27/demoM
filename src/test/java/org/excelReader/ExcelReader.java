package org.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) throws IOException {

		File excelLocation = new File(".\\src\\test\\resources\\Dev\\Map\\Request_TestData.xlsx");

		FileInputStream inputStream = new FileInputStream(excelLocation);

		XSSFWorkbook book = new XSSFWorkbook(inputStream);

		XSSFSheet sheet = book.getSheet("TestData");

		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(0).getLastCellNum();

//		for (int r = 0; r <= lastRowNum; r++) {
//
//			XSSFRow row = sheet.getRow(r);
//			for (int c = 0; c < lastCellNum; c++) {
//				XSSFCell cell = row.getCell(c);
//
//				switch (cell.getCellType()) {
//
//				case STRING:
//					System.out.print(cell.getStringCellValue());
//					break;
//				case NUMERIC:
//					System.out.print(cell.getNumericCellValue());
//					break;
//				case BOOLEAN:
//					System.out.print(cell.getBooleanCellValue());
//					break;
//
//				}
//				System.out.print(" | ");
//			}
//
//			System.out.println();
//		}

		// Using Iterator

		Iterator<Row> iterator = sheet.iterator();

		while (iterator.hasNext()) {

			Row next = iterator.next();

			Iterator<Cell> cellIterator = next.cellIterator();

			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();

				switch (cell.getCellType()) {
				case STRING:
					String stringCellValue = cell.getStringCellValue();
					System.out.print(stringCellValue);
					break;

				case NUMERIC:
					double numericCellValue = cell.getNumericCellValue();
					System.out.print(numericCellValue);
					break;

				case BOOLEAN:
					boolean booleanCellValue = cell.getBooleanCellValue();

					System.out.print(booleanCellValue);
					break;

				}

				System.out.print(" | ");

			}

			System.out.println();
		}

	}

}