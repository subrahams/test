package aero.sita.asl.testTasks.SpringIntegrationTask.handlers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import aero.sita.asl.tasks.processers.OutFileNameGenerator;

/**
 * Test class to check ProcessedFileNameGenerator.
 * @author syed.subhani
 *
 */
public class ProcessedFileNameGeneratorTest {

	private OutFileNameGenerator generator;
	
	/**
	 * Setup the required resources.
	 */
	@Before
	public void setUp(){
		generator = new OutFileNameGenerator();
	}
	
	/**
	 * Tidying up resources
	 */
	@After
	public void tearDown(){
		generator = null;
	}
	
	/**
	 * Test to verify the file name after the generator process.
	 */
	@Test
	public void fileNameVerify(){
		Message<?> message = MessageBuilder.withPayload("Sample").setHeader("file_name", "XYZ.txt").build();		
		String generatedFileName = generator.generateFileName(message);
		Assert.assertEquals("The generated file name is wrong ", "XYZ.OUT", generatedFileName);
	}
}
