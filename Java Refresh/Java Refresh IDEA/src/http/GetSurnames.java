package http;
import records.Name;

import java.io.StringReader;
import java.net.Authenticator;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;


public class GetSurnames {

    private static HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(20))
            .authenticator(Authenticator.getDefault())
            .build();

    private static HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("api.census.gov/data/2010/surname"))
            .timeout(Duration.ofMinutes(2))
            .header("Content-Type", "application/json")
            .GET()
            .build();

    public void getTop100Names(){
        var isError = false;
        Exception error = null;
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            error = e;
        } finally {
            if(isError){
                System.out.printf("Request failed. %s", error);
            }
            else {
                System.out.println("finished");
            }
        }
    }

//    private static Name[] extractNames(String resBody){
//        JsonReader reader = Json.createReader(new StringReader(resBody));
//    }

}

