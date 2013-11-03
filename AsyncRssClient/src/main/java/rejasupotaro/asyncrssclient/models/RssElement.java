package rejasupotaro.asyncrssclient.models;

import android.net.Uri;

import rejasupotaro.asyncrssclient.MediaEnclosure;
import rejasupotaro.asyncrssclient.MediaThumbnail;

public abstract class RssElement {

    public void setTitle(String title) {}

    public void setDescription(String description) {}

    public void setContent(String content) {}

    public void setLink(Uri link) {}

    public void setPubDate(String pubDate) {}

    public void addCategory(String category) {}

    public void setLastBuildDate(String lastBuildDate) {}

    public void setTtl(String ttl) {}

    public void setMediaEnclosure(MediaEnclosure mediaEnclosure) {}

    public void addMediaThumbnail(MediaThumbnail mediaThumbnail) {}
}
