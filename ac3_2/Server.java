package ac3_2;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

import ac3_1.ClientProcess;


public class Server extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			ServerSocket socketServeur = new ServerSocket(1215);
			System.out.println("Le serveur attend la connexion d'un client");
		     while(true){
			 Socket socket = socketServeur.accept();
			 System.out.println("un client est connecté");
			 ClientProcesse client = new ClientProcesse(socket);
			 client.start();
			
			


		}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}