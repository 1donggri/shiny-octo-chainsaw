package exam02.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	
	public static void main(String[] args) {
		try {
			/*
			 * 1. 서버용 소켓 생성
			 */
			ServerSocket sSock = new ServerSocket();
			
			/*
			 * 2. 생성한 소켓에 서버IP 주소, 서버 Port 번호 바인딩(연결)	--> 중요
			 */
			
			// IP 주소를 바이트 배열로 저장 후, getByAddress() 메서드로 IP 주소를 얻는다. 
			byte[] addr = new byte[] {(byte)192, (byte)169, 35, 92};
			InetAddress serverIP = InetAddress.getByAddress(addr);
			// 서버 포트 번호를 정한다.
			int serverPort = 50000;
			
			// IP 주소와 포트 번호를 서버용 소켓 객체에 연결한다.
			InetSocketAddress serverIpPort = new InetSocketAddress(serverIP, serverPort);
			sSock.bind(serverIpPort);
			
			/*
			 * 3. 통신용 입출력 스트림 생성	--> 중요
			 */
			
			// 클라이언트 측에서 접속 요청이 오길 기다린다.
			Socket cSock = sSock.accept();
			
			// 클라이언트용 소켓의 IP 주소, 포트 번호, 지역호스트의 IP 주소를 변수에 저장해서 확인.
			InetAddress clientIP = cSock.getInetAddress();
			int clientPort = cSock.getPort();
			int connectionPort = cSock.getLocalPort();
			
			// 서버 호스트의 IP 주소 : 클라이언트 소켓의 포트 번호 <-------> 클라이언트 호스트의 IP 주소 : 클라이언트 소켓의 포트 번호
			System.out.printf("%s:%d <-------> %s:%d", serverIP.getHostAddress(), connectionPort,
					clientIP.getHostAddress(), clientPort);
			
			/*
			 * 4. 통신용 입출력 스트림 생성
			 */
			
			BufferedReader sockIn = new BufferedReader(new InputStreamReader(cSock.getInputStream()));
			BufferedWriter sockOut = new BufferedWriter(new OutputStreamWriter(cSock.getOutputStream()));
			
			/*
			 * 5. 지속적인 통신을 위한 반복문
			 */
			
			boolean disconnect = false;
			while(true) {
				// 서버로 부터 수신한 메시지가 있으면 반복 진행.
				while(sockIn.ready()) {
					String line = sockIn.readLine();
					if(line.contains("exit")) {
						disconnect = true;
						break;
					}
					System.out.println(line);
				}
				if(disconnect) {
					break;
				}
			}
			
			/*
			 * 6. 통신 종료 후에는 모든 자원 반납.
			 */
			
			sockIn.close();
			sockOut.close();
			cSock.close();
			sSock.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
