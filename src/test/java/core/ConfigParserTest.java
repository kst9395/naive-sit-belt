package core;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.xpquery.core.XPQueryConfigurationService;
import com.xpquery.metadata.XPQueryConfiguration;

public class ConfigParserTest {

	XPQueryConfigurationService serviceUnderTest;
	
	
	
	@BeforeTest
	public void setup() throws ParserConfigurationException, SAXException, IOException {
		serviceUnderTest = new XPQueryConfigurationService();
		
	}
	@Test
	public void canReadConfigurationIntoModel() throws JAXBException {
		InputStream stream = this.getClass().getResourceAsStream("/config.xml");
		XPQueryConfiguration configurationModel = serviceUnderTest.LoadConfiguration(stream);
		assertNotNull(configurationModel);
	}

}
