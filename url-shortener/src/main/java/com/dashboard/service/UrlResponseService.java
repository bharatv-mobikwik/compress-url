package com.dashboard.service;

import com.dashboard.model.UrlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by MOBIKWIK\omk707 on 17/7/17.
 */
@Component
public class UrlResponseService {

    @Autowired
    private MongoService mongoService;

    private final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(this.getClass());

    public String ifExists(String longUrl, HttpServletRequest httpServletRequest){
        UrlEntity oneEntityByLongUrl = mongoService.getOneEntityByLongUrl(longUrl);
        if(oneEntityByLongUrl != null ){
            return  oneEntityByLongUrl.getShortUrl();
        }
        return null;
    }

    public String ifExistsS(String shorturl, HttpServletRequest httpServletRequest){

        String s;
        UrlEntity oneEntityByShortUrl=mongoService.getOneEntityByShortUrl(shorturl);
        s=oneEntityByShortUrl.getLongUrl();
        if(oneEntityByShortUrl!=null){
            return s;
        }
        else
            return "invalid";
    }


    public void incrementDetails(String url,HttpServletRequest http){
        String s;
        s=http.getHeader("User-Agent");
        UrlEntity urlEntity=mongoService.getDetails(url);
        /*
        String userAgentString = http.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(userAgentString);
        OperatingSystem os = userAgent.getOperatingSystem();*/
        if(s=="chrome"){
           int l=urlEntity.getChromeCount();
           l++;
           urlEntity.setChromeCount(l);
           mongoService.save(urlEntity);
        }
        else if (s=="firefox"){
            int l=urlEntity.getFirefoxCount();
            l++;
            urlEntity.setFirefoxCount(l);
            mongoService.save(urlEntity);
        }
        else if (s=="safari"){
            int l=urlEntity.getSafariCount();
            l++;
            urlEntity.setSafariCount(l);
            mongoService.save(urlEntity);
        }

    }


    public static String generateRandomShortToken() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(60, random).toString(20);
    }



    public  String persist(String longUrl,HttpServletRequest httpServletRequest){

        String k=generateRandomShortToken();
        UrlEntity n= new UrlEntity();
        n.setId(k);
        n.setLongUrl(longUrl);
        n.setAndroidCount(0);
        n.setChromeCount(0);
        n.setCounter(0);
        n.setFirefoxCount(0);
        n.setIosCount(0);
        n.setLinuxCount(0);
        n.setOtherBrowser(0);
        n.setOtherPlatform(0);
        n.setSafariCount(0);
        n.setWindowsCount(0);
        n.setShortUrl(k);

        mongoService.save(n) ;
        return "url_inserted";
    }
}
