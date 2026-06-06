import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public class MoviesHandler extends BaseHttpHandler {
    @Override
    public void handle(HttpExchange ex) throws IOException {
        String method = ex.getRequestMethod();
        if (method.equalsIgnoreCase("GET")) {
            sendJson(ex, HTTP_OK, "[]");
        } else {
            ex.sendResponseHeaders(HTTP_METHOD_NOT_ALLOWED, NO_RESPONSE_BODY_LENGTH);
        }
    }
}
