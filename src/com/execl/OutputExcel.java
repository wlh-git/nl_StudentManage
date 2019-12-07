package com.execl;
import java.io.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/**
 * @author Administrator
 * @param file
 * E:\result.xls sheetAt 0:选择题 sheetAt 1:填空题 sheetAt 2:简答题
 */
public class OutputExcel {
	private	FileInputStream fs;		//文件输入流对象
	private	POIFSFileSystem ps;		// 使用POI提供的方法得到excel的信息
	private FileOutputStream fos;//文件输出流对象
	private HSSFWorkbook workbook = null;//excel文档对象
	private HSSFSheet sheet ;//excel的sheet
	private HSSFRow row    ;//excel的行
	private HSSFCell cell  ;//excel的单元格
	private boolean flag ;
	public static void main(String[] args) {
		String[] info = { "zhangsan", "A", "B", "C", "D" };
		try {
			OutputExcel t = new OutputExcel() ;
			t.doOutputExcel(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("deprecation")
	public void doOutputExcel(String[] info) {
		StringBuffer result = null;
		File file = new File("E:" + File.separator + "test.xls");
		doCheck(file,info);
		conn(file);
		sheet = workbook.getSheetAt(0);
		int count = doCheck() ;
		for (int i = 0; i < info.length; i++) {
			try {
				row = sheet.getRow(i) ;
				cell = row.createCell(count) ;
				cell.setCellValue(info[i]) ;
				result = new StringBuffer("考生信息已出入" + file + "表中");
			} catch (Exception e) {
				System.out.println(i + "客户答案出错：" + e.getMessage());
				e.printStackTrace();
			}
		}
		try {
			fos = new FileOutputStream(file);
			fos.flush();
			workbook.write(fos);
			System.out.println(result);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		doWrite(file);
		System.out.println(result);
		close();
	}
	
	/**
	 * 功能:插入选择题进入Excel表中(sheetAt=0)
	 * @param info
	 * @throws Exception
	 */
	public void makeExcelOptions(String[] info) throws Exception {
		File file = new File("E:" + File.separator + "result.xls");
		doCheck(file,info);
		conn(file);
		sheet = workbook.getSheetAt(0);
		int count = 1;
		flag = true;
		row = sheet.getRow(0);
		//判断从第几列开始插入
		while (flag) {
			try {
				cell = row.getCell(count);
				if (row.getCell(count) == null) {
					flag = false;
					break;
				}
			} catch (Exception e) {
				flag = false;
				break;
			}
			count++;
		}
		for (int i = 0; i < info.length; i++) {
			try {
				row = sheet.getRow(i);
				cell = row.createCell(count);
				//cell.setCellValue(info[i]);
				cell.setCellValue(new HSSFRichTextString(info[i]));
			} catch (Exception e) {
				System.out.println(i + "客户答案出错：" + e.getMessage());
			}
		}
		doWrite(file);
		close();
	}

	/**
	 * 功能:插入填空题进入Excel表中(sheetAt=1)
	 * @param info
	 * @throws Exception
	 */
	public void makeExcelFill_ins(String[] info) throws Exception {
		File file = new File("E:" + File.separator + "result.xls");
		doCheck(file,info);
		conn(file);
		sheet = workbook.getSheetAt(1);
		int count = 1;
		flag = true;
		row = sheet.getRow(0);
		while (flag) {
			try {
				cell = row.getCell(count);
				if (row.getCell(count) == null) {
					flag = false;
					break;
				}
			} catch (Exception e) {
				flag = false;
				break;
			}
			count++;
		}
		for (int i = 0; i < info.length; i++) {
			try {
				row = sheet.getRow(i);
				cell = row.createCell(count);
				//cell.setCellValue(info[i]);
				cell.setCellValue(new HSSFRichTextString(info[i]));
			} catch (Exception e) {
				System.out.println(i + "客户答案出错：" + e.getMessage());
			}
		}
		doWrite(file);
		close();
	}
	
	/**
	 * @param file 文件路径
	 * @param sheetAt 第i张sheet表
	 * @param info 插入的数据
	 * @throws Exception
	 */
	public void memoryExcel(File file, int sheetAt, String[] info) throws Exception {		
		doCheck(file,info);
		conn(file);
		sheet = workbook.getSheetAt(sheetAt);
		/*
		 * 判断第一列的题目序号是否有,如果没有就添加上
		 */
		int count = 1;
		flag = true;
		row = sheet.getRow(0);
		while (flag) {
			try {
				cell = row.getCell(count);
				if (row.getCell(count) == null) {
					flag = false;
					break;
				}
			} catch (Exception e) {
				flag = false;
				break;
			}
			count++;
		}
		for (int i = 0; i < info.length; i++) {
			try {
				row = sheet.getRow(i);
				cell = row.createCell(count);
				//cell.setCellValue(info[i]);
				cell.setCellValue(new HSSFRichTextString(info[i]));
			} catch (Exception e) {
				System.out.println(i + "客户答案出错：" + e.getMessage());
			}
		}
		doWrite(file);
		close() ;
	}
	
	/**
	 * 默认第一个sheet表格;
	 * @param file
	 * @param info
	 * @throws Exception
	 */
	public void memoryExcel(File file, String[] info) throws Exception {		
		StringBuffer result = null;
		doCheck(file,info);
		conn(file);
		sheet = workbook.getSheetAt(0);
		int count = 1;
		flag = true;
		row = sheet.getRow(0);
		while (flag) {
			try {
				cell = row.getCell(count);
				if (row.getCell(count) == null) {
					flag = false;
					break;
				}
			} catch (Exception e) {
				flag = false;
				break;
			}
			count++;
		}
		/*
		 * 开始存入客户答案信息
		 */
		for (int i = 0; i < info.length; i++) {
			try {
				row = sheet.getRow(i);
				cell = row.createCell(count);
				//cell.setCellValue(info[i]);
				cell.setCellValue(new HSSFRichTextString(info[i]));
				result = new StringBuffer("考生信息已出入" + file + "表中");
			} catch (Exception e) {
				System.out.println(i + "客户答案出错：" + e.getMessage());
			}
		}

		doWrite(file);
		System.out.println(result);
		close() ;
	}
	
	private void doCheck(File file,String[] info) {
		conn(file);
		sheet = workbook.getSheetAt(0);
		boolean flag ;
		flag = false ;
		row = sheet.getRow(info.length - 2);
		try {
			if (row.getCell(0) == null) {
				flag = true;
				System.out.println("有值");
			}
		} catch (Exception e) {
			flag = true;
		}
		if (flag) {
			for (int i = 0; i < info.length; i++) {
				try {
					row = sheet.createRow(i);
					cell = row.createCell(0);
					if (i==0) {
						//cell.setCellValue("考生姓名");
						cell.setCellValue(new HSSFRichTextString("考生姓名"));						
					}else {
						cell.setCellValue(i + 1);
					}
						
				} catch (Exception e) {
					System.out.println(i + "序号客户答案出错：" + e.getMessage());
				}
			}
		}
		doWrite(file);
		close() ;
	}
	private int doCheck() {
		int count = 1 ;
		flag = true ;
		row = sheet.getRow(0) ;
		while (flag) {
			try {
				if (row.getCell(count) == null) {
					flag = false;
					break;
				}
			} catch (Exception e) {
				flag = false;
				break;
			}
			count++;
		}
		return count;
	}
	private void conn(File file) {
		try {
			fs = new FileInputStream(file);
			ps = new POIFSFileSystem(fs);// 打开Excel的输入流
			workbook = new HSSFWorkbook(ps);//初始化文档对象
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void doWrite(File file) {
		try {
			fos = new FileOutputStream(file);//获取文件输出流
			fos.flush();
			workbook.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void close() {
		try {
			
			if (fos!=null) {
				fos.close() ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
};
