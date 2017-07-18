package com.dashboard.service;

import com.dashboard.model.UrlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MOBIKWIK\omk707 on 17/7/17.
 */

@Repository
public class MongoService {

    @Autowired
    private MongoOperations mongoOperations ;

    public  List<UrlEntity> getEntityByLongUrl(){
        List<UrlEntity> all = mongoOperations.findAll(UrlEntity.class);
        return all ;
    }

    public  List<UrlEntity> getEntityByLongUrl(String longUrl ){
        Query query = new Query();
        query.addCriteria(Criteria.where("longUrl").is(longUrl));
        List<UrlEntity> all = mongoOperations.find(query,UrlEntity.class);
        return all ;
    }

    public UrlEntity getOneEntityByLongUrl(String longUrl ){
        Query query = new Query();
        query.addCriteria(Criteria.where("longUrl").is(longUrl));
        UrlEntity all = mongoOperations.findOne(query,UrlEntity.class);
        return all ;
    }

    public UrlEntity getOneEntityByShortUrl(String shortUrl){
        Query query=new Query();
        query.addCriteria(Criteria.where("shorturl").is(shortUrl));
        UrlEntity all=mongoOperations.findOne(query,UrlEntity.class);
        return all;
    }

    public UrlEntity getDetails(String url){
        Query query= new Query();
        query.addCriteria(Criteria.where("shorturl").is(url));
        UrlEntity all=mongoOperations.findOne(query,UrlEntity.class);
        return all;

    }

    public void save(UrlEntity n) {
        mongoOperations.save(n);
    }
}
