package Challenge2.API;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class HttpRequest {
    private HttpClient httpClient;

    public HttpRequest() {
        httpClient = HttpClients.createDefault();
    }

    public HttpResponse sendRequest(String url) {
        try {
            HttpGet httpGet = new HttpGet(url);
            return httpClient.execute(httpGet);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}


