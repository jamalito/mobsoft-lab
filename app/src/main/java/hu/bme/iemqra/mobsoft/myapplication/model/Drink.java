package hu.bme.iemqra.mobsoft.myapplication.model;
import com.orm.dsl.Table;
/**
 * Created by jamalito on 2017.04.18..
 */
@Table
public class Drink {
    private Long id;
    private String name;
    private String type;
    private String imgUrl;
    private int count;
    private String recomm;

    public Drink(){

    }

    public Drink(Long id, String name, String type, String imgUrl, int count, String recomm) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.imgUrl = imgUrl;
        this.count = count;
        this.recomm = recomm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getRecomm() {
        return recomm;
    }

    public void setRecomm(String recomm) {
        this.recomm = recomm;
    }


}
