package server;

import org.eclipse.jetty.server.*;

@SuppressWarnings({"FieldCanBeLocal","NotNullNullableValidation"})
public class MyServer {
    private final Server server = new Server();
    private final int port = 3307;

    public Server build(){
        return build(port);
    }

    public Server build(int port){
        final HttpConfiguration httpConfiguration = new HttpConfiguration();
        final HttpConnectionFactory connectionFactory = new HttpConnectionFactory(httpConfiguration);
        final ServerConnector connector = new ServerConnector(server,connectionFactory);

        connector.setHost("localhost");
        connector.setPort(port);
        server.setConnectors(new Connector[]{connector});
        return server;
    }
}
