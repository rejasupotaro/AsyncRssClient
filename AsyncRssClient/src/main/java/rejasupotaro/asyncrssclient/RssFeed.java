package rejasupotaro.asyncrssclient;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class RssFeed extends RssElement {

    private String mTitle;

    private String mDescription;

    private Uri mLink;

    private String mPubDate;

    private String mLastBuildDate;

    private int mTtl;

    private List<String> mCategoryList;

    private List<RssItem> mRssItemList;

    private String mSubtitle;

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

    void setLastBuildDate(String lastBuildDate) {
        mLastBuildDate = lastBuildDate;
    }

    public String getLastBuildDate() {
        return mLastBuildDate;
    }

    void setTtl(int ttl) {
        mTtl = ttl;
    }

    public int getTtl() {
        return mTtl;
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

    void addRssItem(RssItem rssItem) {
        if (mRssItemList == null) {
            mRssItemList = new ArrayList<RssItem>();
        }
        mRssItemList.add(rssItem);
    }

    public List<RssItem> getRssItemList() {
        return mRssItemList;
    }

    void setSubtitle(String subtitle) {
        mSubtitle = subtitle;
    }

    public String getSubtitle() {
        return mSubtitle;
    }
}
