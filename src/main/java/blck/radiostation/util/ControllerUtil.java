package blck.radiostation.util;

import org.springframework.http.HttpHeaders;

/**
 * Controller Util.
 *
 * @author Livio Agolini
 */
public record ControllerUtil() {

    public static HttpHeaders getListHeaders(long count, int skip, int limit) {
        var httpHeaders = new HttpHeaders();
        httpHeaders.add("next", ((Boolean) (count > skip + limit)).toString());
        httpHeaders.add("count", String.valueOf(count));
        return httpHeaders;
    }
}
