package rejasupotaro.example.asyncrssclient;

import org.apache.http.Header;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import rejasupotaro.asyncrssclient.AsyncRssClient;
import rejasupotaro.asyncrssclient.AsyncRssResponseHandler;
import rejasupotaro.asyncrssclient.RssFeed;
import rejasupotaro.asyncrssclient.RssItem;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AsyncRssClient client = new AsyncRssClient();
        client.read("http://feeds.rebuild.fm/rebuildfm", new AsyncRssResponseHandler() {
            @Override
            public void onSuccess(RssFeed rssFeed) {
                rssFeed.getTitle(); // => Rebuild
                rssFeed.getDescription(); // => ウェブ開発、プログラミング、モバイル、ガジェットなどにフォーカスしたテクノロジー系ポッドキャストです。
                Log.d("DEBUG", rssFeed.getTitle());
                Log.d("DEBUG", rssFeed.getDescription());

                RssItem rssItem = rssFeed.getRssItemList().get(0);
                rssItem.getTitle(); // => 24: Go, Mavericks, LinkedIn Intro (typester)
                Log.d("DEBUG", rssItem.getTitle());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody,
                    Throwable error) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
