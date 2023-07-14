import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class UrlEncoder implements IEncoder{
    public String encode(String message) {
        try {
            return URLEncoder.encode(message, StandardCharsets.UTF_8);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}
