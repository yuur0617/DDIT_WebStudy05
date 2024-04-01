package kr.or.ddit.Excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest01 {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Workbook wb = new XSSFWorkbook();

		try (OutputStream fileOut = new FileOutputStream("d:/temp/workbook01.xlsx")) {
		    wb.write(fileOut);
		}
	}
}
