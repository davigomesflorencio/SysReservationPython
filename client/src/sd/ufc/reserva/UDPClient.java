package sd.ufc.reserva;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class UDPClient {

	private DatagramSocket socket = null;
	private String serverIP;
	private int port;

	public UDPClient(String serverIP, int port) {
		this.serverIP = serverIP;
		this.port = port;
		try {
			socket = new DatagramSocket();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void sendRequest(byte[] requisicao) {
		byte[] sendData = new byte[1024];
		
		InetAddress IPAddress = null;
		
		try {
			IPAddress = InetAddress.getByName(serverIP);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		sendData = requisicao;

		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

		
		
		try {
			socket.send(sendPacket);
		} catch (IOException e) {
			System.out.println("entou");
			// TODO Auto-generated catch block
			e.printStackTrace();				
		}
		
			
				
	}

	public byte[] getReplay() {
		
		byte[] receiveData = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);		
			
			try {
				socket.receive(receivePacket);
				
			} catch (SocketTimeoutException e1) {
				// TODO Auto-generated catch block
				System.out.println("estouro");
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}						
			
			
			
			return receiveData;
		
	}

	public void finaliza() {
		socket.close();
	}
}