package com.moudy.awqat.Modle;

public class Mycart {
    public String place_name, city_name, neighborhood_name, number_of_people_how_rate,count_of_product;
    private   double price;
    private int place_photo,stars;

    public String getCount_of_product() {
        return count_of_product;
    }

    public void setCount_of_product(String count_of_product) {
        this.count_of_product = count_of_product;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getNeighborhood_name() {
        return neighborhood_name;
    }

    public void setNeighborhood_name(String neighborhood_name) {
        this.neighborhood_name = neighborhood_name;
    }

    public String getNumber_of_people_how_rate() {
        return number_of_people_how_rate;
    }

    public void setNumber_of_people_how_rate(String number_of_people_how_rate) {
        this.number_of_people_how_rate = number_of_people_how_rate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPlace_photo() {
        return place_photo;
    }

    public void setPlace_photo(int place_photo) {
        this.place_photo = place_photo;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Mycart(String place_name, String city_name, String neighborhood_name, String number_of_people_how_rate,String count_of_product, double price, int place_photo, int stars) {
        this.place_name = place_name;
        this.city_name = city_name;
        this.neighborhood_name = neighborhood_name;
        this.number_of_people_how_rate = number_of_people_how_rate;
        this.price = price;
        this.place_photo = place_photo;
        this.stars = stars;

    }
}
