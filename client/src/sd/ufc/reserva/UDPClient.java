package sd.ufc.reserva;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
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
			socket.setSoTimeout(3000);
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public byte[] getReplay() throws SocketTimeoutException{
		
		byte[] receiveData = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		try {
			socket.receive(receivePacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return receiveData;
	}

	public void finaliza() {
		socket.close();
	}
}
