package aero.sita.asl.testTasks.SpringIntegrationTask;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Client class to inject spring configurations and to manage the flow.
 * @author Syed.Subhani
 *
 */
public class SpringIntegrationTaskClient {
    /**
    * Sleep time.
    */
    private static final int FIVE_SECONDS = 10000;
    /**
    * RESOURCES_DIR.
    */
    private static final File RESOURCES_DIR = new File("src/main/resources");
    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(SpringIntegrationTaskClient.class);
    /**
     * context.
     */
    private static String configFile = "springIntegrationTask-applicationContext.xml";
    
    
    
    /**
     * private constructor.
     */
    public SpringIntegrationTaskClient(){
        
    }
    
    public static String getConfigFile() {
        return configFile;
    }

    public static void setConfigFile(final String configFile) {
        SpringIntegrationTaskClient.configFile = configFile;
    }

    /**
     * Main method to launch the spring integration example application.
     * @param args
     */
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext context = null;
        try {
            // Load Log4j configuration
            DOMConfigurator.configure(RESOURCES_DIR + "/log4j.xml");
            LOGGER.debug("Loaded logging configurations");
            // Load Spring configurations
            context = new ClassPathXmlApplicationContext(configFile);
            LOGGER.debug("Loaded spring context.");
            Thread.sleep(FIVE_SECONDS);
        } catch (BeansException e) {
            LOGGER.error("Bean Exception occured in the application." + e);
        } catch (InterruptedException e) {
            LOGGER.error("Error occured while processing files : " + e);
        }
        
        if(context != null) {
            context.close();
        }
    }
}
