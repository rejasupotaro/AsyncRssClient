AsyncRssClient [![Build Status](https://travis-ci.org/rejasupotaro/AsyncRssClient.png?branch=master)](https://travis-ci.org/rejasupotaro/AsyncRssClient)
======

Simple Asyncronous RSS 2.0 reader library for Android.

Installation
---------

Add dependency in your build settings.

```groovy
repositories {
    mavenCentral()
    maven { url 'https://raw.github.com/rejasupotaro/AsyncRssClient/master/AsyncRssClient/repository' }
}

dependencies {
    ...
    compile 'rejasupotaro:async-rss-client:0.0.4'
}
```

Example
---------

### Sample Feed

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" media="screen" href="/~files/feed-premium.xsl"?>
<rss xmlns:atom="http://www.w3.org/2005/Atom" xmlns:itunes="http://www.itunes.com/dtds/podcast-1.0.dtd" xmlns:media="http://search.yahoo.com/mrss/" xmlns:dc="http://purl.org/dc/elements/1.1/" version="2.0">
    <channel>
        <title>Rebuild</title>
        <description>ウェブ開発、プログラミング、モバイル、ガジェットなどにフォーカスしたテクノロジー系ポッドキャストです。</description>
        <generator>Jekyll</generator>
        <link>http://rebuild.fm</link>
        <atom:link href="http://feeds.rebuild.fm/rebuildfm" rel="self" type="application/rss+xml"/>
        <media:thumbnail url="http://rebuild.fm/images/icon240.png"/>
        <media:keywords>tech,technology,programming,perl,ruby,mobile,web,miyagawa,apple,google,android,development,software</media:keywords>
        <media:category scheme="http://www.itunes.com/dtds/podcast-1.0.dtd">Technology</media:category>
        <itunes:author>Tatsuhiko Miyagawa</itunes:author>
        <itunes:explicit>no</itunes:explicit>
        <itunes:image href="http://rebuild.fm/images/icon1400.jpg"/>
        <itunes:keywords>tech,technology,programming,perl,ruby,mobile,web,miyagawa,apple,google,android,development,software</itunes:keywords>
        <itunes:subtitle>A Podcast by Tatsuhiko Miyagawa. Talking about Tech, Software Development and Gadgets.</itunes:subtitle>
        <itunes:summary>ウェブ開発、プログラミング、モバイル、ガジェットなどにフォーカスしたテクノロジー系ポッドキャストです。</itunes:summary>
        <itunes:category text="Technology"/>
        <itunes:owner>
            <itunes:name>Tatsuhiko Miyagawa</itunes:name>
            <itunes:email>miyagawa@bulknews.net</itunes:email>
        </itunes:owner>
        <language>ja</language>

        <item>
            <title>24: Go, Mavericks, LinkedIn Intro (typester)</title>
            ...
```

### Request Feed

```java
AsyncRssClient client = new AsyncRssClient();
client.read("http://feeds.rebuild.fm/rebuildfm", new AsyncRssResponseHandler() {
    @Override
    public void onSuccess(RssFeed rssFeed) {
        rssFeed.getTitle(); // => Rebuild
        rssFeed.getDescription(); // => ウェブ開発、プログラミング、モバイル、ガジェットなどにフォーカスしたテクノロジー系ポッドキャストです。

        RssItem rssItem = rssFeed.getRssItemList().get(0);
        rssItem.getTitle(); // => 24: Go, Mavericks, LinkedIn Intro (typester)
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody,
            Throwable error) {
        ...
    }
});
```

License
---------

```
Copyright 2013 Kentaro Takiguchi

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
