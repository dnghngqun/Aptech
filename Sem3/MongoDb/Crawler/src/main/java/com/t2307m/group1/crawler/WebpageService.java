package com.t2307m.group1.crawler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class WebpageService {
    @Autowired
    private WebpageRepository webpageRepository;

    public void crawlAndSave(String url) throws IOException {
        // Cấu hình đường dẫn đến ChromeDriver
//        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        //khởi tạo webdriver
        WebDriver driver = new SafariDriver();

        try{
            //điều hướng tới url cần crawl
            driver.get(url);
            // Đợi trang tải hoàn tất (nếu cần)
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // Crawl dữ liệu, ví dụ: Lấy tất cả các tiêu đề bài viết trên trang
            List<WebElement> titles = driver.findElements(By.cssSelector("span.pr-title.js__card-title")); // Thay selector này bằng selector bạn cần
// span.re__card-config-price.js__card-config-item
            // span.re__card-config-area.js__card-config-item


            // Lấy mã nguồn HTML của trang
//            String htmlContent = driver.getPageSource();

            // Lưu dữ liệu vào MongoDB
//            WebPage webPage = new WebPage(url, title, htmlContent);

//            webpageRepository.save(webPage);
        } finally {
            // Đóng WebDriver
            driver.quit();
        }
    }
}
