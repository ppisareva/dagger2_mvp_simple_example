package hinapolina.com.dagger2mvp.Data;

import com.orm.SugarRecord;

/**
 * Created by polina on 4/15/18.
 */

public class Item extends SugarRecord{

    int id;
    String image;
    String overview;
    String title;

    public Item(){;

    }
    public Item(String image, String overview, String title) {
        this.image = image;
        this.overview = overview;
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
