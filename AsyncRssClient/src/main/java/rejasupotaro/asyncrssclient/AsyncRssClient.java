package rejasupotaro.asyncrssclient;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class AsyncRssClient {

    public static final AsyncHttpClient mClient = new AsyncHttpClient();

    public void read(String url) {
        mClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, org.apache.http.Header[] headers, byte[] responseBody) {
            }

            @Override
            public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
            }
        });
    }
}
