package com.testdome;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class Folders {
	static class SampleHandler extends DefaultHandler {
		private char startingLetter;
		private Collection<String> result;
		
		public SampleHandler(char startingLetter) {
			this.startingLetter = startingLetter;
			result = new ArrayList();
		}
		public void startDocument() {
		}

		public void endDocument() {
		}

		public void startElement(String namespaceURI, String localName, String qName, Attributes attrs) {
			if("folder".equals(qName)) {
				String name = attrs.getValue("name");
				if (name.charAt(0) == startingLetter) {
					result.add(name);
				}
			}
			
		}

		public void endElement(String namespaceURI, String localName, String qName) {
		}

		public void characters(char[] ch, int start, int length) {
		}
		
		public Collection<String> getCollection() {
			return result;
		}
	}

	public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();

		SampleHandler dh = new SampleHandler(startingLetter);
		parser.parse(new ByteArrayInputStream(xml.getBytes()), dh);
		Collection<String> result = dh.getCollection();
		return result;
	}

	public static void main(String[] args) throws Exception {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<folder name=\"c\">"
				+ "<folder name=\"program files\">" + "<folder name=\"uninstall information\" />" + "</folder>"
				+ "<folder name=\"users\" />" + "</folder>";

		Collection<String> names = folderNames(xml, 'u');
		for (String name : names)
			System.out.println(name);
	}
}