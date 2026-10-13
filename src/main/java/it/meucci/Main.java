package it.meucci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(3000);
        Socket lsocket = s.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(lsocket.getInputStream()));
        PrintWriter out = new PrintWriter(lsocket.getOutputStream(), true);
        String testo = in.readLine();
        do{
            
        }while(testo!="exit");


    }
}