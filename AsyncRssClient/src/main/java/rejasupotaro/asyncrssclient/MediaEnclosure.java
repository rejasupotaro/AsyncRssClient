package rejasupotaro.asyncrssclient;

import android.net.Uri;

public final class MediaEnclosure {
    private final Uri url;
    private final int length;
    private final String mimeType;

    /**
     * Returns the URL of the enclosure. The return value is never {@code null}.
     */
    public Uri getUrl() {
        return url;
    }

    /**
     * Returns the length of the enclosure.
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns the mime type of the enclosure. The return value is never
     * {@code null}.
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Internal constructor for RSSHandler
     */
    MediaEnclosure(android.net.Uri url, int length, String mimeType) {
        this.url = url;
        this.length = length;
        this.mimeType = mimeType;
    }
}
