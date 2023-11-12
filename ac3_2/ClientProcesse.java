package ac3_2;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
public class ClientProcesse extends Thread {
	Socket socket;
	public ClientProcesse (Socket socket ){
		super();
		this.socket = socket;	
	}
	public void run() {
		try {
			 InputStream input = socket.getInputStream();
	         ObjectInputStream oi = new ObjectInputStream(input);
	         OutputStream output =socket.getOutputStream();
	         ObjectOutputStream oo = new ObjectOutputStream(output);
	            while (true) {
	            Operation op = (Operation) oi.readObject();
	            int nb1 = op.getNb1();
	            int nb2 = op.getNb2();
	            char ops = op.getOp();
	            int res = 0;
	            switch(ops){
	                case '+' : res = nb1 + nb2;break;
	                case '-' : res = nb1 - nb2;break;
	                case '*' : res = nb1 * nb2;break;
	                case '/' : res = nb1 / nb2;break;
	            }
	            op.setRes(res);
	            oo.writeObject(op);
		socket.close();
		}}
		catch (IOException e)
		{e.printStackTrace();} catch (ClassNotFoundException e) {
	
			e.printStackTrace();}	}}