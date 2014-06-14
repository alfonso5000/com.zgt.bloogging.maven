package org.bloogging.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Post implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //con Oracle Sequence
    private Integer postId;
    private String title;
    private String content;
    
    @Column(name="createdDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    
    @OneToOne (cascade = {CascadeType.PERSIST})
    private Author author;
    
    /*
    ManyToMany
    List<Tag> tags;
    */
    
    public Post() {
    }

    public Post(String title, String content, Date date, Author author) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.author = author;
    }
    
    /**
     * @return the postId
     */
    public Integer getPostId() {
        return postId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return the author
     */
    public Author getAuthor() {
        return author;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.postId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Post other = (Post) obj;
        if (!Objects.equals(this.postId, other.postId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Post{" + "title=" + title + ", content=" + content + ", date=" + date + ", author=" + author + '}';
    }
    
    
}
