package frc.robot.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RobotServer implements Runnable {
	private ServerSocket server;
	private Socket client;

	private String ip = "127.0.0.1";
	private int port = 3600;

	private boolean isConnected = false;

	private String clientIp;

	private BufferedReader input;
	private PrintWriter output;

	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  

	public RobotServer(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	// FIXME: connecting to the server should be multithreaded in order to not stall
	// the application.
	public void connect() {
		// Create a server and wait for a client to connect.
		System.out.println("Starting Robot Server. Port: " + port + " Ip: " + ip);
		try {
			server = new ServerSocket(port, 1, InetAddress.getByName(ip));

			System.out.println("Looking for client to connect to...");
			client = server.accept();

			// When the client connects, get the client ip and set isConnected to true.
			clientIp = client.getInetAddress().getHostAddress();
			isConnected = true;

			System.out.println("Connected to client " + clientIp);

			// Create an input stream from the client.
			input = new BufferedReader(new InputStreamReader(client.getInputStream()));
			output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));

			System.out.println("Listening for data...");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// FIXME: run doesn't need to exist.
	@Override
	public void run() {
		while (isConnected) {
			if (client.isClosed() == true || server.isClosed()) {
				disconnect();
			}
		}
	}

	public void disconnect() {
		isConnected = false;
		try {
			input.close();
			output.close();

			server.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String read() {
		System.out.println("[" + dateTimeFormatter.format(LocalDateTime.now()) + "] Reading next line.");
		String data;
		try {
			data = input.readLine();
			System.out.println("[" + dateTimeFormatter.format(LocalDateTime.now()) + "] Reading: " + data);
			return data;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void write(String data) {
		output.write(data + '\n');
		output.flush();
		System.out.println("[" + dateTimeFormatter.format(LocalDateTime.now()) + "] Writing: " + data);
	}

	public boolean isinputReady() {
		try {
			return input.ready();
		} catch (IOException e) {
			return false;
		}
	}

}
