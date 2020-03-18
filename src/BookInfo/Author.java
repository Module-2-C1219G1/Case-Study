package BookInfo;

public class Author {
    private String name;
    private int authorCode;
    private String dateOfBird;

    public Author() {

    }

    public Author(String name,int authorCode, String dateOfBird) {
        this.name = name;
        this.authorCode = authorCode;
        this.dateOfBird = dateOfBird;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBird() {
        return dateOfBird;
    }

    public void setDateOfBird(String dateOfBird) {
        this.dateOfBird = dateOfBird;
    }

    public int getAuthorCode() {
        return authorCode;
    }
    public void setAuthorCode(int authorCode) {
        this.authorCode = authorCode;
    }
}
