package com.sunwin.sys.utils;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.sunwin.record.entity.record;

public class ExcelUtil {

	public static HSSFWorkbook toexcel(List<record> list) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("录音统计");
		HSSFRow row = sheet.createRow((int) 0);
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("呼叫方向");
		cell.setCellStyle(style);
		cell = row.createCell(1);
		cell.setCellValue("呼出号码");
		cell.setCellStyle(style);
		cell = row.createCell(2);
		cell.setCellValue("呼入号码");
		cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("通道号");
		cell.setCellStyle(style);
		cell = row.createCell(4);
		cell.setCellValue("录音开始时间");
		cell.setCellStyle(style);
		cell = row.createCell(5);
		cell.setCellValue("录音结束时间");
		cell.setCellStyle(style);

		record r = new record();
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow(i + 1);
			r = list.get(i);
			if ("0".equals(r.getAtpdirect())) {
				row.createCell(0).setCellValue("呼入");
			} else {
				row.createCell(0).setCellValue("呼出");
			}
			row.createCell(1).setCellValue(r.getAtpdtmf());
			row.createCell(2).setCellValue(r.getAtpcaller());
			row.createCell(3).setCellValue(r.getAtpchnum());
			row.createCell(4).setCellValue(DateUtil.parseDateToStr(r.getAtpstarttime(), "yyyy/MM/dd HH:mm:ss"));
			row.createCell(5).setCellValue(DateUtil.parseDateToStr(r.getAtpendtime(), "yyyy/MM/dd HH:mm:ss"));
		}
		// try {
		// FileOutputStream fout = new FileOutputStream("F:/record.xls");
		// wb.write(fout);
		// fout.close();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		return wb;
	}
}
