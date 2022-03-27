package coder;

import java.util.Observable;

/**
 * @auther : wangyufei
 * @date : 2020-12-02
 **/
public class ONewsAgency extends Observable {
    private String news;

    public void setNews(String news) {
        this.news = news;

        setChanged();
        notifyObservers(news);
    }
}
