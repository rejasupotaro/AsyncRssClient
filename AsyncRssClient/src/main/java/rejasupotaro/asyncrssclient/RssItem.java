package rejasupotaro.asyncrssclient;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class RssItem extends RssElement {

    private String mTitle;

    private String mDescription;

    private String mContent;

    private Uri mLink;

    private String mPubDate;

    private List<String> mCategoryList;

    private MediaEnclosure mMediaEnclosure;

    private List<MediaThumbnail> mMediaThumbnailList;

    private String mSubtitle;

    private String mDuration;

    void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    void setContent(String content) {
        mContent = content;
    }

    public String getContent() {
        return mContent;
    }

    void setLink(Uri link) {
        mLink = link;
    }

    public Uri getLink() {
        return mLink;
    }

    void setPubDate(String pubDate) {
        mPubDate = pubDate;
    }

    public String getPubDate() {
        return mPubDate;
    }

    void addCategory(String category) {
        if (mCategoryList == null) {
            mCategoryList = new ArrayList<String>();
        }
        mCategoryList.add(category);
    }

    public List<String> getCategoryList() {
        return mCategoryList;
    }

    void setMediaEnclosure(MediaEnclosure mediaEnclosure) {
        mMediaEnclosure = mediaEnclosure;
    }

    public MediaEnclosure getMediaEnclosure() {
        return mMediaEnclosure;
    }

    void addMediaThumbnail(MediaThumbnail mediaThumbnail) {
        if (mMediaThumbnailList == null) {
            mMediaThumbnailList = new ArrayList<MediaThumbnail>();
        }
        mMediaThumbnailList.add(mediaThumbnail);
    }

    public List<MediaThumbnail> getMediaThumbnail() {
        return mMediaThumbnailList;
    }

    void setSubtitle(String subtitle) {
        mSubtitle = subtitle;
    }

    public String getSubtitle() {
        return mSubtitle;
    }

    void setDuration(String duration) {
        mDuration = duration;
    }

    public String getDuration() {
        return mDuration;
    }
}
