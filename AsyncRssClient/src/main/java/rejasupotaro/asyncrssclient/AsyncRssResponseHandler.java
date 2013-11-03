package rejasupotaro.asyncrssclient;

import org.apache.http.Header;

import rejasupotaro.asyncrssclient.models.RssFeed;

public interface AsyncRssResponseHandler {
    public void onSuccess(RssFeed rssFeed);
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error);
}
