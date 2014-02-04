package rejasupotaro.example.asyncrssclient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import rejasupotaro.example.asyncrssclient.models.Entry;

public class MainActivity extends Activity {

    private ListView mHotEntryListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        requestHotEntry();
    }

    private void findViews() {
        mHotEntryListView = (ListView) findViewById(R.id.hotentry_list_view);
    }

    private void requestHotEntry() {
        HotEntryClient client = new HotEntryClient();
        client.request(new HotEntryClient.HotEntryResponseHandler() {
            @Override
            public void onResponse(List<Entry> rssItemList) {
                setupListView(rssItemList);
            }

            @Override
            public void onErrorResponse() {
                Log.e("DEBUG", "onErrorResponse");
            }
        });

    }

    private void setupListView(List<Entry> entryList) {
        ArrayAdapter<Entry> entryArrayAdapter =
                new ArrayAdapter<Entry>(this, android.R.layout.simple_list_item_1,
                        entryList);
        mHotEntryListView.setAdapter(entryArrayAdapter);
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
