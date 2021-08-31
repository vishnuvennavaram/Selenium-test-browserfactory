package org.vishnu.exceptions;

public class BrowserNotSupportedException extends IllegalStateException {

    public BrowserNotSupportedException(String browser) {
        super(String.format("Browser not supported: %s", browser));
    }
}
