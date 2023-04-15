package retailapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException
{
    /**
     * Constructs a new runtime exception with the specified detail message.
     */
    public ItemNotFoundException(String message)
    {
        super(message);
    }
}


