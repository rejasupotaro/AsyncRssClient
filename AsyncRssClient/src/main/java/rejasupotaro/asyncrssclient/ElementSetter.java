package rejasupotaro.asyncrssclient;

import android.net.Uri;

import org.xml.sax.Attributes;

public enum ElementSetter {
    TITLE("title", new ContentSetter() {
        @Override
        public void set(RssElement element, String value) {
            element.setTitle(value);
        }
    }),
    DESCRIPTION("description", new ContentSetter() {

        @Override
        public void set(RssElement element, String value) {
            element.setDescription(value);
        }
    }),
    CONTENT("content:encode", new ContentSetter() {
        @Override
        public void set(RssElement element, String value) {
            element.setContent(value);
        }
    }),
    LINK("link", new ContentSetter() {
        @Override
        public void set(RssElement element, String value) {
            element.setLink(Uri.parse(value));
        }
    }),
    CATEGORY("category", new ContentSetter() {
        @Override
        public void set(RssElement element, String value) {
            element.addCategory(value);
        }
    }),
    PUB_DATE("pubDate", new ContentSetter() {
        @Override
        public void set(RssElement element, String value) {
            element.setPubDate(value);
        }
    }),
    LAST_BUILD_DATE("lastBuildDate", new ContentSetter() {
        @Override
        public void set(RssElement element, String value) {
            element.setLastBuildDate(value);
        }
    }),
    TTL("ttl", new ContentSetter() {
        @Override
        public void set(RssElement element, String value) {
            element.setTtl(value);
        }
    }),
    MEDIA_THUMBNAIL("media:thumbnail", new AttributeSetter() {

        private static final String MEDIA_THUMBNAIL_HEIGHT = "height";
        private static final String MEDIA_THUMBNAIL_WIDTH = "width";
        private static final String MEDIA_THUMBNAIL_URL = "url";
        private static final int DEFAULT_DIMENSION = -1;

        @Override
        public void set(RssElement element, Attributes attributes) {
            final int height = MediaAttributes.intValue(attributes, MEDIA_THUMBNAIL_HEIGHT, DEFAULT_DIMENSION);
            final int width = MediaAttributes.intValue(attributes, MEDIA_THUMBNAIL_WIDTH, DEFAULT_DIMENSION);
            final String url = MediaAttributes.stringValue(attributes, MEDIA_THUMBNAIL_URL);

            if (url == null) {
                // ignore invalid media:thumbnail elements which have no URL.
                return;
            }

            element.addMediaThumbnail(new MediaThumbnail(android.net.Uri.parse(url), height, width));
        }
    }),
    ENCLOSURE("enclosure", new AttributeSetter() {

        private static final String URL = "url";
        private static final String LENGTH = "length";
        private static final String MIMETYPE = "type";

        @Override
        public void set(RssElement element, Attributes attributes) {
            final String url = MediaAttributes.stringValue(attributes, URL);
            final Integer length = MediaAttributes.intValue(attributes, LENGTH);
            final String mimeType = MediaAttributes.stringValue(attributes,
                    MIMETYPE);

            if (url == null || length == null || mimeType == null) {
                // Ignore invalid elements.
                return;
            }

            MediaEnclosure enclosure = new MediaEnclosure(
                    android.net.Uri.parse(url), length, mimeType);
            element.setMediaEnclosure(enclosure);
        }
    }),
    ITUNES_SUBTITLE("itunes:subtitle", new ContentSetter() {
        @Override
        public void set(RssElement element, String value) {
            element.setSubtitle(value);
        }
    }),
    ITUNES_DURATION("itunes:duration", new ContentSetter() {
        @Override
        public void set(RssElement element, String value) {
            element.setDuration(value);
        }
    });

    private String mQName;

    private Setter mSetter;

    private ElementSetter(String qName, Setter setter) {
        mQName = qName;
        mSetter = setter;
    }

    private static Setter getSetter(String qName) {
        for (ElementSetter elementSetter : ElementSetter.values()) {
            if (elementSetter.mQName.equals(qName)) {
                return elementSetter.mSetter;
            }
        }
        return null;
    }

    public static void setContent(String qName, RssElement element, String content) {
        Setter setter = getSetter(qName);
        if (setter instanceof ContentSetter) {
            ((ContentSetter) setter).set(element, content);
        }
    }
    public static void setAttributes(String qName, RssElement element, Attributes attributes) {
        Setter setter = getSetter(qName);
        if (setter instanceof AttributeSetter) {
            ((AttributeSetter) setter).set(element, attributes);
        }
    }

    public static boolean contains(String qName) {
        return (getSetter(qName) != null);
    }

    public static boolean containsInAttributes(String qName) {
        return (getSetter(qName) instanceof AttributeSetter);
    }

    /**
     * Interface to store information about RSS elements.
     */
    public static interface Setter {}

    /**
     * Closure to change fields in POJOs which store RSS content.
     */
    public static interface ContentSetter extends Setter {
        /**
         * Set the field of an object which represents an RSS element.
         */
        void set(RssElement element, String value);
    }

    /**
     * Closure to change fields in POJOs which store information
     * about RSS elements which have only attributes.
     */
    private static interface AttributeSetter extends Setter {
        /**
         * Set the XML attributes.
         */
        void set(RssElement element, Attributes attributes);
    }
}
