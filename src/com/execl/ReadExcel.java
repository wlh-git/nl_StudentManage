package com.execl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadExcel {
	// 读取填空题
	public String[][] readExcelFill_ins() throws Exception {
		String[][] info = null;
		File file = new File("E:" + File.separator + "fill_ins.xls");
		/*
		 * if(file.isFile()) if (!file.exists()) {
		 * 
		 * }
		 */
		@SuppressWarnings("unused")
		InputStream is = null;
		Workbook wb = null;
		try {
			// 创建输入流,读取excel
			is = new FileInputStream(file);
			wb = Workbook.getWorkbook(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 每个页签创建一个Sheet对象
		Sheet sheet = wb.getSheet(0);
		// sheet.getRows()返回该页的总行数
		int rows = sheet.getRows();
		// 创建一个二维数组用来接收信息
		info = new String[rows][2];
		for (int j = 0; j < rows; j++) {
			// 接收每一行所有单元格的信息
			Cell[] cells = sheet.getRow(j);
			for (int k = 0; k < cells.length; k++) {
				// 将每一个单元的信息放info中
				info[j][k] = cells[k].getContents().trim();
			}
		}
		return info;
	}

	// 读取选择题
	public String[][] readExcelOptions() throws Exception {
		File file = new File("E:" + File.separator + "options.xls");
		@SuppressWarnings("unused")
		InputStream is = null;
		Workbook wb = null;
		try {
			// 创建输入流,读取excel
			is = new FileInputStream(file);
			wb = Workbook.getWorkbook(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 为每一个页签创建一个sheet对象
		Sheet sheet = wb.getSheet(0);
		// 获取总行数
		int rows = sheet.getRows();
		// 创建一个二维数组用来接收信息
		String[][] info = new String[rows][6];
		for (int j = 0; j < rows; j++) {
			// 获取每一行所有的单元格的信息
			Cell[] cells = sheet.getRow(j);
			for (int k = 0; k < cells.length; k++) {
				// 将每一个单元的信息放info中
				info[j][k] = cells[k].getContents().trim();
			}
		}
		return info;
	}

	// 读取指定文件的第一个页签
	public String[][] readExcel(File file) throws Exception {
		@SuppressWarnings("unused")
		InputStream is = null;
		Workbook wb = null;
		try {
			// 创建输入流,读取excel
			is = new FileInputStream(file);
			wb = Workbook.getWorkbook(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 为每一个页签对象创建一个sheet对象
		Sheet sheet = wb.getSheet(0);
		// 获取总行数
		int rows = sheet.getRows();
		// 创建一个二维数组用来接收信息
		String[][] info = new String[rows][6];
		for (int j = 0; j < rows; j++) {
			// 获取每一行所有的单元格的信息
			Cell[] cells = sheet.getRow(j);
			for (int k = 0; k < cells.length; k++) {
				// 将单元格信息存储放入二维数组中
				info[j][k] = cells[k].getContents().trim();
			}
		}
		return info;
	}

	/*
	 * // 读取选择题的指定行 public String[][] readExcel_option(File file, int id) throws
	 * Exception {
	 * 
	 * @SuppressWarnings("unused") InputStream is = null; Workbook wb = null; try {
	 * // 创建文件输入流,读取excel is = new FileInputStream(file); wb =
	 * Workbook.getWorkbook(file); } catch (Exception e) { e.printStackTrace(); } //
	 * 为指定的页签创建一个sheet对象 Sheet sheet = wb.getSheet(0); // 创建一个二维数组用来放置信息 String[][]
	 * info = new String[4][6]; int num = 4 * id; for (int j = num,m=0; j < (num+4)
	 * && m<4; j++,m++) { // 获取每一行的所有的单元格的信息 Cell[] cells = sheet.getRow(j); for
	 * (int k = 0; k < cells.length; k++) { // 将信息存储进入二维数组中 info[m][k] =
	 * cells[k].getContents().trim(); } } return info; }
	 */
	// 读取填空题的行
	public String[][] readExcel_fill(File file, int id) throws Exception {
		@SuppressWarnings("unused")
		InputStream is = null;
		Workbook wb = null;
		try {
			// 创建文件输入流,读取excel
			is = new FileInputStream(file);
			wb = Workbook.getWorkbook(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 为指定的页签创建一个sheet对象
		Sheet sheet = wb.getSheet(0);
		// 创建一个二维数组用来放置信息
		String[][] info = new String[4][2];
		int num = 4 * id;
		for (int j = num,m=0; j < (num+4) && m<4; j++,m++) {
			// 获取每一行的所有的单元格的信息
			Cell[] cells = sheet.getRow(j);
			for (int k = 0; k < cells.length; k++) {
				// 将信息存储进入二维数组中
				info[m][k] = cells[k].getContents().trim();
			}
		}
		return info;
	}
	
	// 读取程序题的行
		public String[][] readExcel_prom(File file, int id) throws Exception {
			@SuppressWarnings("unused")
			InputStream is = null;
			Workbook wb = null;
			try {
				// 创建文件输入流,读取excel
				is = new FileInputStream(file);
				wb = Workbook.getWorkbook(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 为指定的页签创建一个sheet对象
			Sheet sheet = wb.getSheet(0);
			// 创建一个二维数组用来放置信息
			String[][] info = new String[2][2];
			int num = 2 * id;
			for (int j = num,m=0; j < (num+2)&&m<2; j++,m++) {
				// 获取每一行的所有的单元格的信息
				Cell[] cells = sheet.getRow(j);
				for (int k = 0; k < cells.length; k++) {
					// 将信息存储进入二维数组中
					info[m][k] = cells[k].getContents().trim();
				}
			}
			return info;
		}

	// 读取指定文件的指定页签
	public String[][] readExcel(File file, int sheetAt) throws Exception {
		@SuppressWarnings("unused")
		InputStream is = null;
		Workbook wb = null;
		try {
			// 创建文件输入流,读取excel
			is = new FileInputStream(file);
			wb = Workbook.getWorkbook(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 为指定的页签创建一个sheet对象
		Sheet sheet = wb.getSheet(sheetAt);
		// 获取总行数
		int rows = sheet.getRows();
		// 创建一个二维数组用来放置信息
		String[][] info = new String[rows][6];
		for (int j = 0; j < rows; j++) {
			// 获取每一行的所有的单元格的信息
			Cell[] cells = sheet.getRow(j);
			for (int k = 0; k < cells.length; k++) {
				// 将信息存储进入二维数组中
				info[j][k] = cells[k].getContents().trim();
			}
		}
		return info;
	}
}