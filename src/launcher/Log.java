package launcher;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {

	    public static void setupLogging(Level level) {

	        // configuracion de logs
	        Logger log = Logger.getLogger("");
	        for (Handler h : log.getHandlers()) log.removeHandler( h );
	        ConsoleHandler ch = new ConsoleHandler();
	        ch.setFormatter(new SimpleFormatter() {
	            @Override
	            public synchronized String format(LogRecord record) {
	                return record.getMessage() + "\n";
	            }
	        });
	        log.addHandler(ch);
	        log.setLevel(level);
	        ch.setLevel(level);
	    }
	}
