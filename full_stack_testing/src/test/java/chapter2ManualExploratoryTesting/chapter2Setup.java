package chapter2ManualExploratoryTesting;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.http.HttpClient;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class chapter2Setup {
    public static WireMockServer wireMockServer;
    public static HttpClient client;

    @BeforeClass
    public void setUp() {
        // Initialize WireMock server on a dynamic port
        wireMockServer = new WireMockServer(Options.DYNAMIC_PORT);
        wireMockServer.start();
        configureFor("localhost", wireMockServer.port());

        // Initialize shared HttpClient instance
        client = HttpClient.newHttpClient();
    }

    @AfterClass
    public void tearDown() {
        // Stop WireMock server if running
        if (wireMockServer != null && wireMockServer.isRunning()) {
            wireMockServer.stop();
        }
    }
}
