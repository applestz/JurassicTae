package Item.Base;

public class Item {
    private final String name;
    private final String imgUrl;

    public Item(String name, String imgUrl) {
        this.name = name;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
