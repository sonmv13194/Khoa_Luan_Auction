package vn.smartdev.product.dao.model;

/**
 * Created by Nhat on 05/12/2016.
 */
public class ProductImageModel {
    private String url;

    public ProductImageModel(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
