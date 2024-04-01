package kr.or.ddit.Excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest05 {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Workbook wb = new HSSFWorkbook();
		//Workbook wb = new XSSFWorkbook();
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet("new sheet");
		// Create a row and put some cells in it. Rows are 0 based.
		Row row = sheet.createRow(0);
		// Create a cell and put a date value in it.  The first cell is not styled
		// as a date.
		Cell cell = row.createCell(0);
		cell.setCellValue(new Date());
		// we style the second cell as a date (and time).  It is important to
		// create a new cell style from the workbook otherwise you can end up
		// modifying the built in style and effecting not only this cell but other cells.
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setDataFormat(
		    createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
		cell = row.createCell(1);
		cell.setCellValue(new Date());
		cell.setCellStyle(cellStyle);
		//you can also set date as java.util.Calendar
		cell = row.createCell(2);
		cell.setCellValue(Calendar.getInstance());
		cell.setCellStyle(cellStyle);
		// Write the output to a file
		try (OutputStream fileOut = new FileOutputStream("d:/temp/workbook04.xls")) {
		    wb.write(fileOut);
		}
	}
}
