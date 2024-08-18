package com.t2307m.group1;

public class WebItem {
    private static int idCounter = 0; // Biến static để theo dõi giá trị id hiện tại
    //biến static thuộc về class WebItem nên ko bao gồm trong json
    private int id;
    private String title;
    private String price;
    private String area;
    private String pricePerM2;

    public WebItem(String title, String price, String area, String pricePerM2) {
        this(); //gọi constructor default để tăng id
        this.title = title;
        this.price = price;
        this.area = area;
        this.pricePerM2 = pricePerM2;
    }

    private synchronized int generateId() {
        return ++idCounter;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        WebItem.idCounter = idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WebItem() {
        this.id = generateId();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPricePerM2() {
        return pricePerM2;
    }

    public void setPricePerM2(String pricePerM2) {
        this.pricePerM2 = pricePerM2;
    }
}
