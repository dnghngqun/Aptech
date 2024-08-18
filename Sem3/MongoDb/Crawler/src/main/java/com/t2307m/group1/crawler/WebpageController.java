package com.t2307m.group1.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/crawl")
public class WebpageController {
    @Autowired
    private WebpageService webpageService;

    @GetMapping("/")
    public String crawlAndSave(@RequestParam String url) throws IOException {
        webpageService.crawlAndSave(url);
        return "Crawl complete.";
    }
}
