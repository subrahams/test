package aero.sita.asl.tasks.routers;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

/**
 * Router class to send requests to appropriate channel.
 * @author Subraham
 *
 */
public class ChannelFileRouter {

     /** LOGGER to use . */
    private static final Logger LOGGER =
        Logger.getLogger(ChannelFileRouter.class);
    /** LOGGER to use HEADER_FILE_NAME. */
    private static final String HEADER_FILE_NAME = "file_name";
    /** LOGGER to use MSG_RECEIVED. */
    private static final String MSG_RECEIVED = "%s received. Content: %s";
    /** LOGGER to use MSG_SENT. */
    private static final String MSG_SENT = "File %s is sending to Chanel: %s";

    /**
     * Method to receive and process the incoming payload and send to the right.
     * @param msg , not null
     * @return channel , never null
     */
    public final String handleRouting(final Message<String> msg) {
        String fileName = (String) msg.getHeaders().get(HEADER_FILE_NAME);
        String content = msg.getPayload();
        LOGGER.debug(String.format(MSG_RECEIVED, fileName, content));
        String channel = checkContent(content);
        LOGGER.info(String.format(MSG_SENT, fileName, channel));
        return channel;
    }

    /**
     * Method to decide the right channel.
     * @param content , not null
     * @return the channel , never null
     */
    private String checkContent(final String content) {
        String[] contents = content.split("\n");
        boolean isValid = true;
        for (String line : contents) {
            try {
                Long.parseLong(line.trim());
            } catch (NumberFormatException e) {
                isValid = false;
                break;
            }
        }
        if (isValid) {
            return "validChannel";
        }
        return "invalidChannel";
    }
}
