package aero.sita.asl.tasks.processers;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

/**
 * Prepare content for the output message and build message with new content.
 * 
 * @author Syed.Subhani
 *
 */
public class OutFileProcessor {

    /**
     * Method to process the input payload and generate the result. 
     * Will send new payload to the output channel.
     * 
     * @param message
     * @return
     */
    public Object sumAllNumbers(Message<?> message) {
        String content = generateContent(message.getPayload().toString());
        Message<String> output = MessageBuilder.withPayload(content).copyHeaders(message.getHeaders()).build();
        return output;
    }

    /**
     * Read the content from the input. Will sum each line and add to result.
     * 
     * @param payload
     * @return the sum of the lines.
     */
    private String generateContent(String payload) {
        long sum = 0;
        String[] lines = payload.split("\n");
        for (String line : lines) {
            // All the lines will be in proper number format as specified by router.
            sum = sum + Long.valueOf(line.trim());
        }
        return String.valueOf(sum);
    }
}
