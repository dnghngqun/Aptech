package com.t2307m.group1.crawler;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WebpageRepository extends MongoRepository<WebPage, String> {

}
