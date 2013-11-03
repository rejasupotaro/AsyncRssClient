package rejasupotaro.asyncrssclient;

import rejasupotaro.asyncrssclient.models.RssFeed;

public class RssResponseHandler {

    public RssFeed parse(String responseBody) {
        return new RssFeed(responseBody);
    }
}
