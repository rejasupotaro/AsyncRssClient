package rejasupotaro.asyncrssclient;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.protocol.HTTP;

import rejasupotaro.asyncrssclient.models.RssFeed;

public class AsyncRssClient {

    public static final AsyncHttpClient mClient = new AsyncHttpClient();

    public static final RssResponseHandler mHandler = new RssResponseHandler();

    public void read(String url, final AsyncRssResponseHandler handler) {
        mClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    RssFeed rssFeed = mHandler.parse(new String(responseBody, HTTP.UTF_8));
                    handler.onSuccess(rssFeed);
                } catch (Exception error) {
                    handler.onFailure(statusCode, headers, responseBody, error);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                handler.onFailure(statusCode, headers, responseBody, error);
            }
        });
    }
}
