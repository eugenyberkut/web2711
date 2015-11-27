package tables;

import java.util.Objects;

/**
 * Created by Yevhen on 27.11.2015.
 */
public class Book {
    private int id;
    private String nazvanie;
    private int pages;
    private int avtorId;
    private int izdatelstvoId;

    public Book(int id, String nazvanie, int pages, int avtorId, int izdatelstvoId) {
        this.setId(id);
        this.setNazvanie(nazvanie);
        this.setPages(pages);
        this.setAvtorId(avtorId);
        this.setIzdatelstvoId(izdatelstvoId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getAvtorId() {
        return avtorId;
    }

    public void setAvtorId(int avtorId) {
        this.avtorId = avtorId;
    }

    public int getIzdatelstvoId() {
        return izdatelstvoId;
    }

    public void setIzdatelstvoId(int izdatelstvoId) {
        this.izdatelstvoId = izdatelstvoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return id == book.id &&
                pages == book.pages &&
                avtorId == book.avtorId &&
                izdatelstvoId == book.izdatelstvoId &&
                Objects.equals(nazvanie, book.nazvanie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazvanie, pages, avtorId, izdatelstvoId);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", nazvanie='" + nazvanie + '\'' +
                ", pages=" + pages +
                ", avtorId=" + avtorId +
                ", izdatelstvoId=" + izdatelstvoId +
                '}';
    }
}
