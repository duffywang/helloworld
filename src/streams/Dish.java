package streams;

import java.util.Objects;

/**
 * @auther : wangyufei
 * @date : 2019-10-03
 **/
public class Dish {

    private String name;
    private Integer price;
    private String review;

    public Dish() {
    }

    public Dish(String name, Integer price, String review) {
        this.name = name;
        this.price = price;
        this.review = review;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        Dish dish = (Dish) o;
        return name.equals(dish.name) &&
                price.equals(dish.price) &&
                review.equals(dish.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, review);
    }
}
