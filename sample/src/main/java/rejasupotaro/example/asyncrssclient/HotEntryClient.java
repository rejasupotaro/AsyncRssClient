package rejasupotaro.example.asyncrssclient;

import org.apache.http.Header;

import android.util.Log;

import java.util.List;

import rejasupotaro.asyncrssclient.AsyncRssClient;
import rejasupotaro.asyncrssclient.AsyncRssResponseHandler;
import rejasupotaro.asyncrssclient.RssFeed;
import rejasupotaro.asyncrssclient.RssItem;
import rejasupotaro.example.asyncrssclient.models.Entry;

public class HotEntryClient {

    private static final String TAG = HotEntryClient.class.getSimpleName();

    private static final AsyncRssClient sClient = new AsyncRssClient();

    private static final String HOTENTRY_RSS_URL = "http://b.hatena.ne.jp/hotentry?mode=rss";

    public static interface HotEntryResponseHandler {

        public void onResponse(List<Entry> rssItemList);

        public void onErrorResponse();
    }

    public void request(final HotEntryResponseHandler handler) {
        sClient.read(HOTENTRY_RSS_URL, new AsyncRssResponseHandler() {
            @Override
            public void onSuccess(RssFeed rssFeed) {
                List<RssItem> rssItemList = rssFeed.getRssItemList();
                handler.onResponse(Entry.fromRssItem(rssItemList));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody,
                    Throwable error) {
                Log.e(TAG, "Request hot entry failed", error);
                handler.onErrorResponse();
            }
        });
    }
}
