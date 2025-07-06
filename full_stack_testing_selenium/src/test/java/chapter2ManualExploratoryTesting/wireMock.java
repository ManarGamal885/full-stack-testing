package chapter2ManualExploratoryTesting;

import chapter2ManualExploratoryTesting.setup.chapter2Setup;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class wireMock extends chapter2Setup {
    private static final String resourceEndPoint = "/my/resource";
    private static final String resourceBody = "<response>SUCCESS</response>";

    @Test
    public void testPostResource() throws IOException, InterruptedException {
        // Stub POST endpoint
        stubFor(post(resourceEndPoint)
                .withHeader("Content-Type", containing("xml"))
                .willReturn(ok()
                        .withHeader("Content-Type", "text/xml")
                        .withBody(resourceBody)));

        // Build POST request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(wireMockServer.url(resourceEndPoint)))
                .header("Content-Type", "text/xml")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        // Send request and capture response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("RESPONSE" + response.body());
        // Assertions
        Assert.assertEquals(response.statusCode(), 200, "Wrong response status code");
        Assert.assertTrue(response.body().contains(resourceBody), "Wrong response body");
    }
}
