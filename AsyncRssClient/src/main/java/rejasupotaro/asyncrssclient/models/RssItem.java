package rejasupotaro.asyncrssclient.models;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import rejasupotaro.asyncrssclient.MediaEnclosure;
import rejasupotaro.asyncrssclient.MediaThumbnail;

public class RssItem extends RssElement {

    private String mTitle;

    private String mDescription;

    private String mContent;

    private Uri mLink;

    private String mPubDate;

    private List<String> mCategoryList;

    private MediaEnclosure mMediaEnclosure;

    private List<MediaThumbnail> mMediaThumbnailList;

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public String getContent() {
        return mContent;
    }

    public void setLink(Uri link) {
        mLink = link;
    }

    public Uri getLink() {
        return mLink;
    }

    public void setPubDate(String pubDate) {
        mPubDate = pubDate;
    }

    public String getPubDate() {
        return mPubDate;
    }

    public void addCategory(String category) {
        if (mCategoryList == null) {
            mCategoryList = new ArrayList<String>();
        }
        mCategoryList.add(category);
    }

    public List<String> getCategoryList() {
        return mCategoryList;
    }

    public void setMediaEnclosure(MediaEnclosure mediaEnclosure) {
        mMediaEnclosure = mediaEnclosure;
    }

    public MediaEnclosure getMediaEnclosure() {
        return mMediaEnclosure;
    }

    public void addMediaThumbnail(MediaThumbnail mediaThumbnail) {
        if (mMediaThumbnailList == null) {
            mMediaThumbnailList = new ArrayList<MediaThumbnail>();
        }
        mMediaThumbnailList.add(mediaThumbnail);
    }

    public List<MediaThumbnail> getMediaThumbnail() {
        return mMediaThumbnailList;
    }
}
