package rejasupotaro.asyncrssclient;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class RssHandler extends DefaultHandler {
    /**
     * Constant for XML element name which identifies RSS mRssItems.
     */
    private static final String RSS_ITEM = "item";

    /**
     * Reference is never {@code null}. Visibility must be package-private to
     * ensure efficiency of inner classes.
     */
    private final RssFeed mRssFeed = new RssFeed();

    /**
     * Reference is {@code null} unless started to parse &lt;mRssItem&gt; element.
     * Visibility must be package-private to ensure efficiency of inner classes.
     */
    private RssItem mRssItem;

    /**
     * If not {@code null}, then buffer the characters inside an XML text element.
     */
    private StringBuilder mStringBuilder;

    private boolean mHasSetter;

    /**
     * Identify the appropriate dispatcher which should be used to store XML data
     * in a POJO. Unsupported RSS 2.0 elements are currently ignored.
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        mHasSetter = ElementSetter.contains(qName);
        if (!mHasSetter) {
            if (RSS_ITEM.equals(qName)) {
                mRssItem = new RssItem();
            }
        } else if (ElementSetter.containsInAttributes(qName)) {
            ElementSetter.setAttributes(
                    qName,
                    (mRssItem == null ? mRssFeed : mRssItem),
                    attributes);
        } else {
            // Buffer supported RSS content data
            mStringBuilder = new StringBuilder();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (isBuffering()) {
            ElementSetter.setContent(
                    qName,
                    (mRssItem == null ? mRssFeed : mRssItem),
                    mStringBuilder.toString());
            mStringBuilder = null;
        } else if (RSS_ITEM.equals(qName)) {
            mRssFeed.addRssItem(mRssItem);

            // (re)enter <channel> scope
            mRssItem = null;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) {
        if (isBuffering()) {
            mStringBuilder.append(ch, start, length);
        }
    }

    /**
     * Determines if the SAX parser is ready to receive data inside an XML element
     * such as &lt;title&gt; or &lt;description&gt;.
     *
     * @return boolean {@code true} if the SAX handler parses data inside an XML
     *         element, {@code false} otherwise
     */
    boolean isBuffering() {
        return mStringBuilder != null && mHasSetter;
    }

    /**
     * Returns the RSS feed after this SAX handler has processed the XML document.
     */
    RssFeed getRssFeed() {
        return mRssFeed;
    }
}
