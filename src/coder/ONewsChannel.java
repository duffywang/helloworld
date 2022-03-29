package coder;

import java.util.Observable;
import java.util.Observer;

/**
 * @auther : wangyufei
 * @date : 2020-12-02
 **/
public class ONewsChannel implements Observer {

    private String news;

    @Override
    public void update(Observable o, Object news) {
        this.setNews((String) news);
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
