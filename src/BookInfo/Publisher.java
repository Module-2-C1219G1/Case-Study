package BookInfo;

public class Publisher {
    private String name;
    private int publisherCode;

    public Publisher() {
    }

    public Publisher(String name, int publisherCode) {
        this.name = name;
        this.publisherCode = publisherCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublisherCode() {
        return publisherCode;
    }

    public void setPublisherCode(int publisherCode) {
        this.publisherCode = publisherCode;
    }
}
