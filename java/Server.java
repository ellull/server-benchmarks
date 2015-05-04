
import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.lang.StringBuilder;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.util.concurrent.Executors;

public class Server {

	public static void main(String[] args) throws Exception {
		int numCPUs = 0;
		if (args.length == 1) {
			numCPUs = Integer.parseInt(args[0]);
		} else {
			numCPUs = Runtime.getRuntime().availableProcessors();
		}
		System.out.println("Using numCPUs = " + numCPUs);

		HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
		server.createContext("/", new MyHandler());
		server.setExecutor(Executors.newFixedThreadPool(numCPUs));
		server.start();
	}

	static class MyHandler implements HttpHandler {
		public void handle(HttpExchange t) throws IOException {
			InputStream requestBody = t.getRequestBody();
			BufferedReader reader = new BufferedReader(new InputStreamReader(requestBody));
			StringBuilder out = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			String response = "" + out.toString().length();
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}
}

