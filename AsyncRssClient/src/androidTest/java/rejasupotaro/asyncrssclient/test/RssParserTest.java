package rejasupotaro.asyncrssclient.test;

import android.net.Uri;
import android.test.InstrumentationTestCase;

import rejasupotaro.asyncrssclient.RssParser;
import rejasupotaro.asyncrssclient.RssFeed;
import rejasupotaro.asyncrssclient.RssItem;

public class RssParserTest extends InstrumentationTestCase {

    public void testParse() throws Exception {
        String testData = AssetsUtils.read(getInstrumentation(), "feeds_rebuild_fm.xml");
        assertNotNull(testData);

        RssParser rssParser = new RssParser();

        RssFeed rssFeed = rssParser.parse(testData);
        assertNotNull(rssFeed);
        assertEquals("Rebuild", rssFeed.getTitle());
        assertEquals("ウェブ開発、プログラミング、モバイル、ガジェットなどにフォーカスしたテクノロジー系ポッドキャストです。", rssFeed.getDescription());
        assertEquals(Uri.parse("http://rebuild.fm"), rssFeed.getLink());
        assertEquals(24, rssFeed.getRssItems().size());

        RssItem rssItem = rssFeed.getRssItems().get(0);
        assertNotNull(rssItem);
        assertEquals("24: Go, Mavericks, LinkedIn Intro (typester)", rssItem.getTitle());
        assertNotNull(rssItem.getDescription());
        assertEquals("Thu, 31 Oct 2013 00:00:00 -0700", rssItem.getPubDate());
        assertEquals(Uri.parse("http://rebuild.fm/24/"), rssItem.getLink());
        assertEquals(Uri.parse("http://tracking.feedpress.it/link/1949/5437/podcast-ep24.mp3"), rssItem.getMediaEnclosure().getUrl());
        assertEquals("Daisuke Muraseさん (@typester) をゲストに迎えて、Go,  OS X Mavericks, Safari Notifications, LinkedIn Intro, Tweetbot などについて話しました。", rssItem.getSubtitle());
        assertEquals("51:34", rssItem.getDuration());
    }
}
