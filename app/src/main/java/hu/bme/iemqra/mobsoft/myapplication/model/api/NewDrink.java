package hu.bme.iemqra.mobsoft.myapplication.model.api;

import com.google.gson.annotations.SerializedName;

public class NewDrink {
    @SerializedName("name")
    private String name = null;

    @SerializedName("type")
    private String type = null;

    @SerializedName("imgUrl")
    private String imgUrl = null;

    @SerializedName("count")
    private String count = null;

    @SerializedName("recomm")
    private String recomm = null;

    public NewDrink() {
    }

    public NewDrink(String name, String type, String imgUrl, String count, String recomm) {
        this.name = name;
        this.type = type;
        this.imgUrl = imgUrl;
        this.count = count;
        this.recomm = recomm;
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getRecomm() {
        return recomm;
    }

    public void setRecomm(String recomm) {
        this.recomm = recomm;
    }
}
