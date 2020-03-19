package BookInfo;

public class Category {
    private String name;
    private boolean isCategory = false;
    private int categoryCode ;

     public Category(){
         this.isCategory = true;
     }
    public Category(String name,int categoryCode){
        this.name = name;
        this.isCategory = true;
        this.categoryCode = categoryCode;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public boolean isHasCategory() {
        return isCategory;
    }

    @Override
    public String toString() {
        return
                "Name: " + name + "\n" +
                "category Code: " + categoryCode ;
    }
}
