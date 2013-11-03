package rejasupotaro.asyncrssclient.models;

import java.util.List;

import rejasupotaro.asyncrssclient.models.Channel;
import rejasupotaro.asyncrssclient.models.Item;

public class RssFeed {

    private Channel mChannel;

    private List<Item> mItemList;

    public RssFeed(String responseBody) {
    }
}
