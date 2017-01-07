
public class Publication {

    String name;
    String 	publisher;
    int sizeInPages;

    public Publication () {

    }

    public Publication (String name, String publisher, int sizeInPages) {
        this.name = name;
        this.publisher = publisher;
        this.sizeInPages = sizeInPages;
    }

    public String getName() {
        return this.name;
    }
    public String getPublisher() {
        return this.publisher;
    }
    public int getSizeInPages() {
        return this.sizeInPages;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPublisher(String publisher) {
        this.publisher =  publisher;
    }
    public void setSizeInPages(int sizeInPages) {
        this.sizeInPages = sizeInPages;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", sizeInPages=" + sizeInPages +
                '}';
    }
}
