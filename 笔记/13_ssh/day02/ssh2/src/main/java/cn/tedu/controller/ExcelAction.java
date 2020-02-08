package cn.tedu.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class ExcelAction extends AbstractAction {
	
	private InputStream excel;
	
	public InputStream getExcel() {
		return excel;
	}
	public void setExcel(InputStream excel) {
		this.excel = excel;
	}
	
	private byte[] createExcel() 
		throws IOException{
		//创建工作簿
		HSSFWorkbook workbook=new HSSFWorkbook();
		//创建工作表
		HSSFSheet sheet=
				workbook.createSheet("Demo");
		//在工作表中创建数据行
		HSSFRow row = sheet.createRow(0);
		//创建行中的格子
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("Hello World!"); 
		//将Excel文件保存为 byte 数组
		ByteArrayOutputStream out =
				new ByteArrayOutputStream();
		workbook.write(out);
		out.close();
		return out.toByteArray();
	}
	
	public String execute() throws IOException{
		
		byte[] buf = createExcel();
		excel = new ByteArrayInputStream(buf);
		
		return SUCCESS;
	}

}






