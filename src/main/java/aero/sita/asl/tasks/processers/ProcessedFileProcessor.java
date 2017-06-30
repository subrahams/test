package aero.sita.asl.tasks.processers;

import org.springframework.messaging.Message;

/**
 * Prepare content for the output message and build message with new content.
 * @author Subraham
 *
 */
public class ProcessedFileProcessor {

    /**
     * Method to process the input payload and generate the result.
     * Will send new payload to the output channel.
     * @param message , not null
     * @return message , never null
     */
    public Object processedFileName(Message<?> message) {
        return message;
    }

}
