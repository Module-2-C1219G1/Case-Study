package BookInfo;

public class Publisher {
    private String name;
    private int publisherCode;
    private boolean isPublisher = false;

    public Publisher() {
        this.isPublisher = true;
    }

    public Publisher(String name, int publisherCode) {
        this.name = name;
        this.publisherCode = publisherCode;
      this.isPublisher = true;
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

    public boolean isHasPublisher() {
        return  isPublisher;
    }

    @Override
    public String toString() {
        return
                "Name: " +name + '\n' +
                "Publisher Code: "+ publisherCode ;
    }
}
