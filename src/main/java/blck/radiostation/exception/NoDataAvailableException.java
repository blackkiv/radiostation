package blck.radiostation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * No Data Available Exception.
 *
 * @author Livio Agolini
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoDataAvailableException extends RuntimeException {

    public NoDataAvailableException(String message) {
        super(message);
    }
}
