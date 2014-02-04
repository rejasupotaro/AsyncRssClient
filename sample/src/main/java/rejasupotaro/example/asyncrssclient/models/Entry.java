package rejasupotaro.example.asyncrssclient.models;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import rejasupotaro.asyncrssclient.RssItem;

public class Entry {

    public String mTitle;

    public String mDescription;

    public String mContent;

    public Uri mLink;

    public Entry() {
    }

    public Entry(String title, String description, String content, Uri link) {
        mTitle = title;
        mDescription = description;
        mContent = content;
        mLink = link;
    }

    public static Entry fromRssItem(RssItem rssItem) {
        if (rssItem == null) {
            return new Entry();
        }

        Entry entry = new Entry(
                rssItem.getTitle(),
                rssItem.getDescription(),
                rssItem.getContent(),
                rssItem.getLink());
        return entry;
    }

    public static List<Entry> fromRssItem(List<RssItem> rssItemList) {
        List<Entry> entryList = new ArrayList<Entry>();
        if (rssItemList == null || rssItemList.isEmpty()) {
            return entryList;
        }

        for (RssItem rssItem : rssItemList) {
            entryList.add(fromRssItem(rssItem));
        }
        return entryList;
    }
}
