package aero.sita.asl.tasks.processers;

import org.springframework.integration.file.FileNameGenerator;
import org.springframework.messaging.Message;

/**
 * Custom Generator class used to update the name of the file.
 * @author Subraham
 *
 */
public class OutFileNameGenerator implements FileNameGenerator {

    /**
     * Method to update the filename by FileWritingMessageHandler
     * @param message
     * @return the updated file name
     */
    public String generateFileName(Message<?> message) {
    	String fileNameWithExt = message.getHeaders().get("file_name").toString();
    	String fileName = fileNameWithExt.replaceFirst(".txt", "") + ".OUT";
        return fileName;
    }
}
