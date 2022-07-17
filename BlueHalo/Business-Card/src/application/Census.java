package application;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.stream.Stream;

/**
 * Class for accessing name data from US Census API
 */

public class Census {

    /**
     * private default constructor
     */
    private Census(){
        super();
    }

    /**
     * This method calls an api from the US Census office to get a list
     * of the 500 most common last names of people living in
     * America.
     * @return Stream(String)
     * @see "<a href="https://api.census.gov/data/2010/surname?get=NAME&RANK=1:500">Census API URL</a>"
     * @throws IOException
     * @throws InterruptedException
     */
    private static Stream<String> getNames() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .proxy(ProxySelector.getDefault())
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.census.gov/data/2010/surname?get=NAME&RANK=1:500"))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofLines()).body();


    }

    /**
     * This method checks if a possible last name taken from the card ocr is in the 500
     * names from the Census API.
     * @param name
     * @return boolean
     */
    public static boolean checkNames(String name) {
        try {
            return getNames()
                    .anyMatch(set -> set.contains(name.toUpperCase()));
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
