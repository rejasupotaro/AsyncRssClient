package rejasupotaro.example.asyncrssclient;

import org.apache.http.Header;

import java.util.List;

import rejasupotaro.asyncrssclient.AsyncRssClient;
import rejasupotaro.asyncrssclient.AsyncRssResponseHandler;
import rejasupotaro.asyncrssclient.RssFeed;
import rejasupotaro.asyncrssclient.RssItem;

public class HotEntryClient {

    private static final AsyncRssClient sClient = new AsyncRssClient();

    private static final String HOTENTRY_RSS_URL = "http://b.hatena.ne.jp/hotentry?mode=rss";

    public static interface HotEntryResponseHandler {

        public void onResponse(List<RssItem> rssItemList);

        public void onErrorResponse();
    }

    public void request(final HotEntryResponseHandler handler) {
        sClient.read(HOTENTRY_RSS_URL, new AsyncRssResponseHandler() {
            @Override
            public void onSuccess(RssFeed rssFeed) {
                List<RssItem> rssItem = rssFeed.getRssItemList();
                handler.onResponse(rssItem);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody,
                    Throwable error) {
                handler.onErrorResponse();
            }
        });
    }
}
