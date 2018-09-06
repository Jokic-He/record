package com.sunwin.tools;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.sunwin.model.TWake;

public class toExcel {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		public void toexcel(List<TWake> list) {
			// ��һ��������һ��webbook����Ӧһ��Excel�ļ�
			HSSFWorkbook wb = new HSSFWorkbook();
			// �ڶ�������webbook�����һ��sheet,��ӦExcel�ļ��е�sheet
			HSSFSheet sheet = wb.createSheet("���Ѽ�¼");
			// ����������sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������short
			HSSFRow row = sheet.createRow((int) 0);
			// ���Ĳ���������Ԫ�񣬲�����ֵ��ͷ ���ñ�ͷ����
			HSSFCellStyle style = wb.createCellStyle();

			style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ����һ�����и�ʽ

			HSSFCell cell = row.createCell(0);
			cell.setCellValue("��¼ʱ��");
			cell.setCellStyle(style);
			cell = row.createCell(1);
			cell.setCellValue("���õķ���");
			cell.setCellStyle(style);
			cell = row.createCell(2);
			cell.setCellValue("����ʱ��");
			cell.setCellStyle(style);
			cell = row.createCell(3);
			cell.setCellValue("���ѷ���");
			cell.setCellStyle(style);
			cell = row.createCell(4);
			cell.setCellValue("�Ƿ�ɹ�");
			cell.setCellStyle(style);

			// ���岽��д��ʵ������ ʵ��Ӧ������Щ���ݴ����ݿ�õ���

			TWake wake = new TWake();
			String success="";
			for (int i = 0; i < list.size(); i++) {
				row = sheet.createRow(i + 1);
	            wake=list.get(i);
				// ���Ĳ���������Ԫ�񣬲�����ֵ
				row.createCell(0).setCellValue(sdf.format(wake.getSetDate()));
				row.createCell(1).setCellValue(wake.getSetNum());
				row.createCell(2).setCellValue(wake.getWakeTime());
				row.createCell(3).setCellValue(wake.getRoomNum());
				if(wake.getSuccess()==1){
					success="�ɹ�";
				}
				if(wake.getSuccess()==2){
					success="���óɹ�";
				}
				if(wake.getSuccess()==3){
					success="�޸ĳɹ�";
				}
				if(wake.getSuccess()==4){
					success="ɾ���ɹ�";
				}
				if(wake.getSuccess()==5){
					success="ʧ��";
				}
				row.createCell(4).setCellValue(success);
			}
			// �����������ļ��浽ָ��λ��
			try {
				FileOutputStream fout = new FileOutputStream("D:/wakelog/wakeup.xls");
				wb.write(fout);
				fout.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


