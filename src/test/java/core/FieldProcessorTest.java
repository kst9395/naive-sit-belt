package core;

import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.xpquery.core.FieldProcessor;
import com.xpquery.metadata.FieldDefinition;
import com.xpquery.metadata.SingleFieldDefinition;
import com.xpquery.metadata.XPQueryConfiguration;

public class FieldProcessorTest {

	Document testData;
	Document noLabelTestData;
	FieldProcessor fieldProcessor;
	FieldProcessor noLabelFieldProcessor;
	private List<SingleFieldDefinition> mockConfigModel() {
		List<SingleFieldDefinition> definitions = new ArrayList<>();
		SingleFieldDefinition fieldDefinition=new SingleFieldDefinition();
		fieldDefinition.setLabelQuery("//DataList/Data/DataKey");
		fieldDefinition.setValueQuery("//DataList/Data/DataValue");
		definitions.add(fieldDefinition);
		return definitions;
	}

	@BeforeTest
	public void setup() throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputStream testDataStream = getClass().getResourceAsStream("/test-data.xml");
		InputStream missingLabelDataStream = getClass().getResourceAsStream("/test-data-without-label.xml");
		testData = builder.parse(testDataStream);
		testData.normalize();
		testDataStream.close();
		noLabelTestData=builder.parse(missingLabelDataStream);
		noLabelTestData.normalize();
		missingLabelDataStream.close();
		XPQueryConfiguration configuration = new XPQueryConfiguration();
		FieldDefinition fieldDefinition = new FieldDefinition();
		fieldDefinition.setDefinitions(mockConfigModel());
		configuration.setFieldDefinition(fieldDefinition);
		
		fieldProcessor = new FieldProcessor(testData, configuration);
		noLabelFieldProcessor = new FieldProcessor(noLabelTestData, configuration);
	}
	
	@Test
	public void canParseFieldBaseOnModel() throws XPathExpressionException{
		HashMap<String, String> parsedResult = fieldProcessor.ProcessFields();
		assertTrue(!parsedResult.isEmpty());
	}
	
	@Test
	public void shouldFailIfFieldHasNoLabel(){
		assertThrows(noLabelFieldProcessor::ProcessFields);
		
	}

}
