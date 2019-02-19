package it.pkg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppBegin
{    
    private static final Logger log = LoggerFactory.getLogger(AppBegin.class);

    public static void main(String[] args)
    {
        log.trace("Hello World");
        log.debug("Hello World");
        log.info("Hello World");
        log.warn("Hello World");
        log.error("Hello World");
    }
}
