package exam01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Sample04 {

	public static void main(String[] args) {
		/*
		 * FileReader 클래스
		 * 		- 바이트 기반 스트림으로 바이트 단위로 파일을 읽는다.
		 * 		- 미디어, 이미지, 텍스트 파일 등 모든 종류의 파일 읽기 가능
		 */
		
		File f = new File("C:/Users/donggri/eclipse/jee-2021-12/eclipse/read_test.txt");
		StringBuilder sb = new StringBuilder();
		FileReader fr = null;
		try {
			FileInputStream fis = new FileInputStream(f);
			/* 영문을 읽을 때에는 아래의 방식으로도 충분
			while(true) {
				int i = fis.read();
				if(i == -1) {
					break;
				}
				sb.append((char)i);
			}
			*/
			byte[] buffer = new byte[4];
			byte[] readChars = new byte[0];
			
			while(true) {
				int i = fis.read(buffer);
				
				if(i == -1) {
					break;
				}
				
				int endIndex = readChars.length;
				readChars = Arrays.copyOf(readChars, readChars.length + i);
				System.arraycopy(buffer, 0, readChars, endIndex, i);
			}
			
			sb.append(new String(readChars));
			System.out.println(sb.toString());
			
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileInputStream 클래스로 읽을 파일을 찾지 못했습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일을 읽는 과정에 문제가 발생하였습니다.");
			e.printStackTrace();
		}
	}

}
