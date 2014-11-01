package rejasupotaro.asyncrssclient;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.protocol.HTTP;

public class AsyncRssClient {

    private static final AsyncHttpClient sClient = new AsyncHttpClient();

    private static final RssParser sHandler = new RssParser();

    public static void setUserAgent(String userAgent) {
        sClient.setUserAgent(userAgent);
    }

    public void read(String url, final AsyncRssResponseHandler handler) {
        sClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] body) {
                try {
                    RssFeed rssFeed = sHandler.parse(body);
                    handler.onSuccess(rssFeed);
                } catch (Exception error) {
                    handler.onFailure(statusCode, headers, body, error);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                handler.onFailure(statusCode, headers, responseBody, error);
            }
        });
    }
}
