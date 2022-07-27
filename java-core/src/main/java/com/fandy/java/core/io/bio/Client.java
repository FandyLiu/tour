package com.fandy.java.core.io.bio;

import java.io.*;
import java.net.Socket;

/**
 * @author: fandy
 * @date: 2019/4/8
 * @description:
 */
public class Client {
    private static String  HOST = "127.0.0.1";
    private static int PORT = 18032;

    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            socket = new Socket(HOST, PORT);
            System.out.println("Client OK");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("给服务器一段话");
            String response = in.readLine();
            System.out.println("Client接收到信息：" + response);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
