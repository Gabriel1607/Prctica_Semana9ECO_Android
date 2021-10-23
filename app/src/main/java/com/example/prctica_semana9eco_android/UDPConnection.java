package com.example.prctica_semana9eco_android;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPConnection extends Thread {
    private DatagramSocket socketcito;
    private OnMessage observer;
    private MainActivity main;

    //Patrón Observer
    public void setObserver (OnMessage observer) {
        this.observer = observer;
    }
    @Override
    public void run() {
        try {
            socketcito = new DatagramSocket(6969);

            while (true) {

                // Recibir mensaje
                byte[] buffer = new byte[100];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // Esperando datagram
                Log.e(">>>", "Esperando datagrama");
                socketcito.receive(packet);

                // Contructor de String para pasar de de bytes a string
                String msg = new String(packet.getData()).trim();
                Log.e(">>>","Datagrama recibido" + msg);

                //Deserialización
                observer.onReceivedMessage(msg);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendMessage(String msg) {
        new Thread(
                ()->{

                    try {
                        InetAddress ip = InetAddress.getByName("192.168.1.6");
                        DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, ip, 6968);
                        socketcito.send(packet);

                    } catch (UnknownHostException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
        ).start();

    }
}
