package rejasupotaro.asyncrssclient;

import android.net.Uri;

public abstract class RssElement {

    void setTitle(String title) {
    }

    void setDescription(String description) {
    }

    void setContent(String content) {
    }

    void setLink(Uri link) {
    }

    void setPubDate(String pubDate) {
    }

    void addCategory(String category) {
    }

    void setLastBuildDate(String lastBuildDate) {
    }

    void setTtl(String ttl) {
    }

    void setMediaEnclosure(MediaEnclosure mediaEnclosure) {
    }

    void addMediaThumbnail(MediaThumbnail mediaThumbnail) {
    }

    void setSubtitle(String subtitle) {
    }

    void setDuration(String subtitle) {
    }
}
