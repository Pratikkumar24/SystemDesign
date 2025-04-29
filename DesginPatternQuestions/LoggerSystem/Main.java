package LoggerSystem;
import LoggerSystem.Loggers.*;
import LoggerSystem.LogOutputStrategy.*;
import LoggerSystem.Loggers.Error;
public class Main {
    public static void main(String[] args) {
        LogHandler trace = new Trace(null);
        trace.setPrintingStrategy(new Console());
        LogHandler warn = new Warn(null);
        warn.setPrintingStrategy(new Console());
        LogHandler error = new Error(null);
        error.setPrintingStrategy(new File());
        LogHandler info = new Info(null);
        info.setPrintingStrategy(new Console());
        LogHandler fatal = new Fatal(null);
        fatal.setPrintingStrategy(new File());
        LogHandler debug = new Debug(null);
        debug.setPrintingStrategy(new Console());

        // Setting the handlers
        trace.setHandler(debug);
        debug.setHandler(info);
        info.setHandler(warn);
        warn.setHandler(error);
        error.setHandler(fatal);
        
        LogHandler logger = trace;
        logger.log(LEVEL.DEBUG, "My dummy Message");
    }
}
