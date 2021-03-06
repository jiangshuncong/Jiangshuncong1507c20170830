package bean;

/**
 * Created by 蒋順聪 on 2017/8/30.
 */

public class BeanMsg {
    private String title;
    private String date;
    private String author_name;
    private String thumbnail_pic_s;

    @Override
    public String toString() {
        return "BeanMsg{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", author_name='" + author_name + '\'' +
                ", thumbnail_pic_s='" + thumbnail_pic_s + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
    }

    public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    public BeanMsg() {

    }

    public BeanMsg(String title, String date, String author_name, String thumbnail_pic_s) {

        this.title = title;
        this.date = date;
        this.author_name = author_name;
        this.thumbnail_pic_s = thumbnail_pic_s;
    }
}
