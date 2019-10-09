package frc.robot.communication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public final class TestClient {

	public static void run(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(12, 1, InetAddress.getByName("127.0.0.1"));
		System.out.println("Listening for data...");

		Socket client = server.accept();
		BufferedReader inputStream = new BufferedReader(new InputStreamReader(client.getInputStream()));

		String clientAddress = client.getInetAddress().getHostAddress();
		String data = "Connected to client.";
		while (data != null) {
			System.out.println("\r\nMessage from " + clientAddress + ": " + data);
			data = inputStream.readLine();
		}

		server.close();
	}

}
