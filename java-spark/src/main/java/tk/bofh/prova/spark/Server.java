package tk.bofh.prova.spark;

import static spark.Spark.*;

public class Server {
    public static void main(String[] args) {
        post("/", (req, res) -> req.contentLength());
    }
}
