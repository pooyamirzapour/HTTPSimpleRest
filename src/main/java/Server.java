import com.sun.net.httpserver.HttpServer;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.uri.internal.JerseyUriBuilder;


import java.net.URI;
import java.util.concurrent.Executors;

public class Server {
    private static HttpServer restServer;

    public static void main(String[] args) {
        URI baseUri = JerseyUriBuilder.fromUri("http://0.0.0.0/").port(1000).build();
        ResourceConfig config = new ResourceConfig(Controller.class);
        restServer = JdkHttpServerFactory.createHttpServer(baseUri, config, false);
        restServer.setExecutor(Executors.newFixedThreadPool(10));
        restServer.start();
    }
}
