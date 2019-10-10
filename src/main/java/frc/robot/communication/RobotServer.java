package frc.robot.communication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class RobotServer implements Runnable {
	ServerSocket server;
	Socket client;

	private String ip = "127.0.0.1";
	private int port = 3600;

	private boolean isConnected = false;

	private String clientIp;

	private BufferedReader input;
	private BufferedWriter output;

	public RobotServer(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	// FIXME: connecting to the server should be multithreaded in order to not stall the application.
	public void connect() throws Exception {
		// Create a server and wait for a client to connect.
		server = new ServerSocket(port, 1, InetAddress.getByName(ip));
		System.out.println("Listening for data...");

		client = server.accept();

		// When the client connects, get the client ip and set isConnected to true.
		clientIp = client.getInetAddress().getHostAddress();
		isConnected = true;

		System.out.println("Connected to client " + clientIp);

		// Create an input stream from the client.
		input = new BufferedReader(new InputStreamReader(client.getInputStream()));
		output = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
	}

	// FIXME: run doesn't need to exist.
	@Override
	public void run() {
		while (isConnected) {
			if (client.isClosed() == true || server.isClosed()) {
				try {
					disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void disconnect() throws IOException {
		isConnected = false;
		input.close();
		output.close();

		server.close();
		client.close();
	}

	public String read() throws IOException {
		while(input.ready() == false) {}

		System.out.println("Reading next line...");
		String data = input.readLine();
		System.out.println("---Next has been read.");

		return data;
	}

	public void write(String data) throws IOException {
		System.out.println("Writing " + data + " to client...");
		output.write(data);
		System.out.println("---" + data + " has been written to the client.");
	}

	public boolean isReadReady() {
		try {
			return input.ready();
		} catch (IOException e) {
			return false;
		}
	}

}
