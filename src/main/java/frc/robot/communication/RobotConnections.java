package frc.robot.communication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class RobotConnections implements Runnable {
    private ServerSocket server;
    private List<Socket> clients = new ArrayList<Socket>();

    public RobotConnections(ServerSocket server) {
        this.server = server;
    }

    @Override
    public void run() {
        // TODO: Switch from `while(true)` to `while(isConnected)` or something.

        while (true) {
            try {
                Socket client = server.accept();
                // TODO: Add ip whitelist and other checks.
                System.out.println("Client "+client.getInetAddress().getHostAddress()+"has connected.");
                clients.add(client);
            } catch (IOException e) { e.printStackTrace(); }

        }
    }

}