package Challenge2.API;

public class HttpResponse {
    private HttpResponse<String> response;

    public HttpResponse(HttpResponse<String> response) {
        this.response = response;
    }

    public String getBody() {
        return response.body();
    }

    public int getStatus() {
        return response.statusCode();
    }
}
