package com.sunwin.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.sunwin.model.TWake;

/**
 * 鏈被鐨勪綔鐢ㄦ槸鎻愪緵闈欐�佹柟娉曞皢鑾峰彇鐨勬暟鎹浆鎹㈡垚wake瀵硅薄list
 * 
 * @author 浣曞煿璧�
 *
 */
public class checkWake {

	static StringBuilder sb = new StringBuilder();
	static String str;

	public List<TWake> check() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yy HH:mm");
		BufferedReader br;
		String setTime;
		List<TWake> list = new ArrayList<TWake>();
		String line;
		try {
			br = new BufferedReader(new FileReader("C:/Users/as/Desktop/wakeuplog.log"));

			while ((line = br.readLine()) != null) {
				TWake wake = new TWake();
				String[] zu = line.split(" ");

				if (zu[4].equals("WAKE")) {
					wake.setRoomNum(zu[7]);
					setTime = zu[0] + " " + zu[1];
					wake.setSetDate(sdf1.parse(setTime));
					wake.setSuccess(1);
					list.add(wake);
				} else if (zu[9].equals("REQUEST") && zu.length == 20) {
					wake.setRoomNum(zu[14]);
					setTime = zu[0] + " " + zu[1];
					wake.setSetDate(sdf1.parse(setTime));
					wake.setSuccess(2);
					wake.setSetNum(zu[4]);
					wake.setWakeTime(setTime = zu[19]);
					list.add(wake);
				} else if (zu[9].equals("REQUEST") && zu.length == 21) {
					wake.setRoomNum(zu[14]);
					setTime = zu[0] + " " + zu[1];
					wake.setSetDate(sdf1.parse(setTime));
					wake.setSuccess(2);
					wake.setSetNum(zu[4]);
					wake.setWakeTime(setTime = zu[20]);
					list.add(wake);

				} else if (zu[9].equals("MODIFICATION") && zu.length == 20) {
					wake.setRoomNum(zu[13]);
					setTime = zu[0] + " " + zu[1];
					wake.setSetDate(sdf1.parse(setTime));
					wake.setSuccess(3);
					wake.setSetNum(zu[4]);
					wake.setWakeTime(setTime = zu[19]);
					list.add(wake);

				} else if (zu[9].equals("MODIFICATION") && zu.length == 19) {
					wake.setRoomNum(zu[13]);
					setTime = zu[0] + " " + zu[1];
					wake.setSetDate(sdf1.parse(setTime));
					wake.setSuccess(3);
					wake.setSetNum(zu[4]);
					wake.setWakeTime(setTime = zu[18]);
					list.add(wake);

				} else if (zu[4].equals("NO")) {
					wake.setRoomNum(zu[9]);
					setTime = zu[0] + " " + zu[1];
					wake.setSetDate(sdf1.parse(setTime));
					wake.setSuccess(5);
					list.add(wake);

				} else if (zu[9].equals("CANCELLATION") && zu.length == 20) {
					wake.setRoomNum(zu[13]);
					setTime = zu[0] + " " + zu[1];
					wake.setSetDate(sdf1.parse(setTime));
					wake.setSuccess(4);
					wake.setSetNum(zu[4]);
					wake.setWakeTime(setTime = zu[19]);
					list.add(wake);
				} else if (zu[9].equals("CANCELLATION") && zu.length == 19) {
					wake.setRoomNum(zu[13]);
					setTime = zu[0] + " " + zu[1];
					wake.setSetDate(sdf1.parse(setTime));
					wake.setSuccess(4);
					wake.setSetNum(zu[4]);
					wake.setWakeTime(setTime = zu[18]);
					list.add(wake);
				}
			}
			br.close();
			return list;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;

	}
}

class TextFilter implements FilenameFilter {

	/**
	 * file: 闇�瑕佽繃婊ょ殑鏂囦欢澶� pirfix: 闇�瑕佽繃婊ょ殑鏂囦欢鍚庣紑 .txt
	 */
	public boolean accept(File file, String pirfix) {
		if (file.isFile()) {
			String fileName = file.getName();
			return fileName.endsWith(pirfix);
		}
		return false;
	}

}
