package frc.cerberus5725.communication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class RobotClient {

	private DatagramSocket socket;
	
	private int port = 3800;
	private String ip = "127.0.0.1";

	private int maxBufferSize = 8;
	

	public RobotClient(int port, String ip) {
		this.ip = ip;
		this.port = port;

		try {
			socket = new DatagramSocket();
		}
		catch (SocketException e) {
			System.out.println(e.getMessage());
		}
	}


	public void ReciveData() throws IOException {
		System.out.println("Listening for data...");

		byte[] buffer = new byte[maxBufferSize];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ip), port);

		socket.receive(packet);
		System.out.println("Got Data!");

		String output = new String(packet.getData(), 0, packet.getLength()) + ", from address: " + packet.getAddress() + ", port: " + packet.getPort();
		System.out.println(output);
	}
}