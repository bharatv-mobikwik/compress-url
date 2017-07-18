package com.commons.config;

/**
 * Created by bharat on 24/11/16.
 */

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;


@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${mongo.host:172.17.0.4}")
    private String dbhost;

    @Value("${mongo.port:27017}")
    private Integer dbport;

    @Value("${mongo.databaseName:hotels}")
    private String dbname;

    @Value("${mongo.connectionsPerHost:50}")
    private int connectionPerHost;

    @Value("${mongo.maxWaitTime:1500}")
    private int maxWaitTime;

    @Value("${mongo.connectTimeout:1000}")
    private int connectionTimeOut;

    @Value("${mongo.socketTimeout:1500}")
    private int socketTimeOut;

    @Value("${mongo.socketKeepAlive:true}")
    private boolean socketKeepAlive;

    @Value("${mongo.autoConnectRetry:true}")
    private boolean autoConnectRetry;

    public
    @Bean
    MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(dbhost), dbname);
    }


    public
    @Bean
    MongoDbFactory mongoEntityVFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(dbhost), dbname);
    }

    @Override
    protected String getDatabaseName() {
        return dbname;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(dbhost);
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.mobikwik.hotel";
    }



}
