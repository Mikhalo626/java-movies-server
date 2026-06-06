import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class MoviesServer {
    private static final int PORT = 8080;
    private static final int BACKLOG = 0;
    private static final int STOP_DELAY = 0;

    private final HttpServer server;

    public MoviesServer() {
        try {
            server = HttpServer.create(new InetSocketAddress(PORT), BACKLOG);
            server.createContext("/movies", new MoviesHandler());
        } catch (IOException e) {
            throw new RuntimeException("Не удалось создать HTTP-сервер", e);
        }
    }

    public void start() {
        server.start();
        System.out.println("Сервер запущен");
    }

    public void stop() {
        server.stop(STOP_DELAY);
        System.out.println("Сервер остановлен");
    }
}
