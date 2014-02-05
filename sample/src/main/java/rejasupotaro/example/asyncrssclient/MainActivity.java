package rejasupotaro.example.asyncrssclient;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import rejasupotaro.example.asyncrssclient.adapters.EntryAdapter;
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
                showToast("An error occured while requesting feed");
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    private void setupListView(List<Entry> entryList) {
        final EntryAdapter entryAdapter = new EntryAdapter(this, entryList);
        mHotEntryListView.setAdapter(entryAdapter);
        mHotEntryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Entry entry = entryAdapter.getItem(position);
                openBrowser(entry.getLink());
            }
        });
    }

    private void openBrowser(Uri uri) {
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
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
