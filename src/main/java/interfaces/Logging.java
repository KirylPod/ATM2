package interfaces;

import client.AbstractClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface Logging {

    String ATM_START = "ATM Start";

    default public Logger getLogger(){
        return LogManager.getLogger(this.getClass());
    }
}
