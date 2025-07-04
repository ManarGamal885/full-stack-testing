package chapter3AutomatedFunctionalTesting.models;

public class Category {
    private String category;
    private Usertype usertype;

    public Category(String category, Usertype usertype) {
        this.category = category;
        this.usertype = usertype;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Usertype getUsertype() {
        return usertype;
    }

    public void setUsertype(Usertype usertype) {
        this.usertype = usertype;
    }
}
