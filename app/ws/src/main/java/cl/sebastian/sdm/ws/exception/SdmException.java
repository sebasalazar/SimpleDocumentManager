package cl.sebastian.sdm.ws.exception;

public class SdmException extends Exception {

    /**
     * Creates a new instance of <code>SdmException</code> without detail
     * message.
     */
    public SdmException() {
    }

    /**
     * Constructs an instance of <code>SdmException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public SdmException(String msg) {
        super(msg);
    }
}
