package com.sunwin.service;

import java.util.List;

import com.sunwin.model.TWake;
import com.sunwin.pageModel.Wake;
import com.sunwin.tools.DataGrid;

public interface wakeI {
	
	// �����ݴ�����У�5����ǰ�����ݲ����ظ�����
		void saveDBFive(List<TWake> list);

		// �����ݴ�����У�5����ǰ�����ݲ����ظ�����
		void saveDB(List<TWake> list);

		// �����ݴ�����У�30����ǰ�����ݲ����ظ�����
		void saveDBHalf(List<TWake> list);

		// �����ݴ�����У�60����ǰ�����ݲ����ظ�����
		void saveDBHour(List<TWake> list);

		// ��ѯ���ݲ�����һ��DateGridʵ��
		DataGrid find(Wake pwake);

		// ��ѯ���е�����
		DataGrid findAll(Wake p);

//		// ɾ��7��ǰ������
//		void deleteDBSeven(PageWake p);

		// ɾ������ǰ�����ݵ�����
		void deleteDB(Wake p);

		// ������excel
		void ToExcel(Wake p);

}
