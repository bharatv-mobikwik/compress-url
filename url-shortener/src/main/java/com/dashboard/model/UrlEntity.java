package com.dashboard.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by MOBIKWIK\omk707 on 17/7/17.
 */
@Document(collection = "urlentity")
public class UrlEntity {

    @Id
    String id;

    String shortUrl;
    String longUrl;
    String tag;
    int counter;
    int chromeCount;
    int firefoxCount;
    int safariCount;
    int otherBrowser;
    int androidCount;
    int windowsCount;
    int iosCount;
    int linuxCount;
    int otherPlatform;

    public String getId() {
        return id;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public String getTag() {
        return tag;
    }

    public int getCounter() {
        return counter;
    }

    public int getChromeCount() {
        return chromeCount;
    }

    public int getFirefoxCount() {
        return firefoxCount;
    }

    public int getSafariCount() {
        return safariCount;
    }

    public int getOtherBrowser() {
        return otherBrowser;
    }

    public int getAndroidCount() {
        return androidCount;
    }

    public int getWindowsCount() {
        return windowsCount;
    }

    public int getIosCount() {
        return iosCount;
    }

    public int getLinuxCount() {
        return linuxCount;
    }

    public int getOtherPlatform() {
        return otherPlatform;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setChromeCount(int chromeCount) {
        this.chromeCount = chromeCount;
    }

    public void setFirefoxCount(int firefoxCount) {
        this.firefoxCount = firefoxCount;
    }

    public void setSafariCount(int safariCount) {
        this.safariCount = safariCount;
    }

    public void setOtherBrowser(int otherBrowser) {
        this.otherBrowser = otherBrowser;
    }

    public void setAndroidCount(int androidCount) {
        this.androidCount = androidCount;
    }

    public void setWindowsCount(int windowsCount) {
        this.windowsCount = windowsCount;
    }

    public void setIosCount(int iosCount) {
        this.iosCount = iosCount;
    }

    public void setLinuxCount(int linuxCount) {
        this.linuxCount = linuxCount;
    }

    public void setOtherPlatform(int otherPlatform) {
        this.otherPlatform = otherPlatform;
    }
}
