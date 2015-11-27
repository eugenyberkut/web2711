package tables;

import java.util.Objects;

/**
 * Created by Yevhen on 27.11.2015.
 */
public class Avtor {
    private int id;
    private String name;
    private String comment;

    public Avtor(int id, String name, String comment) {
        this.id = id;
        this.name = name;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Avtor)) return false;
        Avtor avtor = (Avtor) o;
        return id == avtor.id &&
                Objects.equals(name, avtor.name) &&
                Objects.equals(comment, avtor.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, comment);
    }

    @Override
    public String toString() {
        return "Avtor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
