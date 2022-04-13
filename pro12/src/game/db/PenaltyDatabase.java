package game.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PenaltyDatabase {
	
	private String userHome;
	private File file;
	private String[] penaltys;
	
	public PenaltyDatabase() {
		this.userHome = System.getProperty("user.home");
		this.file = new File(userHome + "/up_down.penalty");
		this._parser(this._load());
	}
	
	public void add(String data) {
		this.penaltys = Arrays.copyOf(this.penaltys, this.penaltys.length + 1);
		try(FileWriter fw = new FileWriter(this.file, true)) {
			this.penaltys[this.penaltys.length - 1] = data;
			fw.write(data + "\n");
			fw.flush();
		} catch (IOException e) {
			System.out.println("파일을 읽는 과정에 문제가 발생하였습니다.");
			e.printStackTrace();
		}
	}

	public String[] getList() {
		return this.penaltys.clone();
	}
	
	public void modify(int index, String penalty) {
		String[] penaltys = getList();
		penaltys[index] = penalty;
		
		try(FileWriter fw = new FileWriter(file)){
			for(int i = 0; i < penaltys.length; i++) {
				fw.write(penaltys[i] + "\n");
			}
			fw.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void remove(int index) {
		String[] penaltys = this.getList();
		
		String[] temp = new String[penaltys.length - 1];
		// System.arraycopy(원본, 원본의 시작지점, 복사 목적지, 복사대상의 시작지점, 문자의 길이)
		System.arraycopy(penaltys, 0, temp, 0, index);
		System.arraycopy(penaltys, index + 1, temp, index, penaltys.length - (index + 1));
		penaltys = temp;
		
		try(FileWriter fw = new FileWriter(file)){
			for(int i = 0; i < penaltys.length; i++) {
				fw.write(penaltys[i] + "\n");
			}
			fw.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// 파일 불러오기 (읽어오기)
	private String _load() {
		try(FileReader fr = new FileReader(this.file)) {
			char[] buffer = new char[1024];		// buffer : 중간 저장소
			char[] data = new char[0];			// data : 최종 저장소
			while(true) {
				
				// buffer 에 파일을 1Byte 만큼 읽어와서 저장하고,
				// 파일에서 buffer 로 읽어온 문자의 길이를 리턴
				int rCnt = fr.read(buffer);
				
				// 파일이 끝나면 종료
				if(rCnt == -1) {
					break;
				}
				
				// 복사하기 전 data 의 길이 (복사 시작점)
				int stIdx = data.length;
				// 읽어온 만큼 길이 복사 (공간 만들기)
				data = Arrays.copyOf(data, data.length + rCnt);
				// System.arraycopy(원본, 원본의 시작지점, 복사 목적지, 복사대상의 시작지점, 문자의 길이)
				System.arraycopy(buffer, 0, data, stIdx, rCnt);
			}
			
			return new String(data);
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}
	
	private void _parser(String data) {
		// data를 "\n"를 기준으로 토큰 단위로 구분
		StringTokenizer st = new StringTokenizer(data, "\n");
		// .countTokens() 은 st의 토큰의 개수
		String[] res = new String[st.countTokens()];
		int idx = 0;
		while(st.hasMoreTokens()) {
			res[idx] = st.nextToken();
			idx++;
		}
		this.penaltys = res.clone();
	}
	

}
