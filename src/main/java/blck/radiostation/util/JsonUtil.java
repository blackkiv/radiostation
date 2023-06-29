package blck.radiostation.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json Util.
 *
 * @author Livio Agolini
 */
public record JsonUtil() {

    public static boolean validJson(String content) {
        try {
            new ObjectMapper().readTree(content);
            return true;
        } catch (JsonProcessingException e) {
            return false;
        }
    }
}
