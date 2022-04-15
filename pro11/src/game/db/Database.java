package game.db;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import game.record.Record;

public class Database {
	
	private File file;
	private Record rec;
	
	public Database() {
		this.file = new File("C:/Users/donggri/gbo_game.record");
	}
	
	public Database(File file) {
		this.file = file;
	}
	
	public int[] load() {
		// 데이터 불러오기
		int[] score = new int[3];
		try(DataInputStream dis = new DataInputStream(new FileInputStream(file))){
			for(int i = 0; i < score.length; i++) {
				score[i] = dis.readInt();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return score;
	}
	
	public void save(int[] record) {
		// 데이터 저장하기
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
			for(int i = 0; i < record.length; i++) {
				dos.writeInt(record[i]);
			}
			dos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
