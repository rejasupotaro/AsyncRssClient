package rejasupotaro.asyncrssclient;

import org.apache.http.protocol.HTTP;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class RssResponseHandler {

    public RssFeed parse(String responseBody) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        RssHandler handler = new RssHandler();

        xmlReader.setContentHandler(handler);
        InputSource source = new InputSource(
                new ByteArrayInputStream(responseBody.getBytes(HTTP.UTF_8)));
        xmlReader.parse(source);

        return handler.getRssFeed();
    }
}
