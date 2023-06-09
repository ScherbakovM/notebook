package notebook.log.impl;

import notebook.log.Logger;
import java.time.LocalDateTime;

public class ConsoleLogger implements Logger {
    public ConsoleLogger( ) {
    }

    @Override
    public void log(String text) {
        System.err.println(LocalDateTime.now() + ": " + text);
    }
}
