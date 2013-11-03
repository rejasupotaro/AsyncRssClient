package rejasupotaro.asyncrssclient;

public class MediaAttributes {

    private MediaAttributes() {}

    /**
     * Returns the RSS 2.0 attribute with the specified local name as a string.
     * The return value is {@code null} if no attribute with such name exists.
     */
    static String stringValue(org.xml.sax.Attributes attributes, String name) {
        return attributes.getValue(name);
    }

    /**
     * Returns the RSS 2.0 attribute with the specified local name as an integer.
     * The {@code defaultValue} is returned if no attribute with such name exists.
     */
    static int intValue(org.xml.sax.Attributes attributes, String name, int defaultValue) {
        final String value = stringValue(attributes, name);
        if (value == null) {
            return defaultValue;
        }

        return Integer.parseInt(value);
    }

    /**
     * Returns the RSS 2.0 attribute with the specified local name as an
     * integer. The return value is {@code null} if no attribute with such name
     * exists.
     */
    static Integer intValue(org.xml.sax.Attributes attributes, String name) {
        final String value = stringValue(attributes, name);
        if (value == null) {
            return null;
        }
        return Integer.parseInt(value);
    }
}