package org.bloogging.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
public class Comment implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="commentId")
    private Integer id;
    //@Transient quitaria de serializable el siguiente campo, p.e. con passwords
    private String content;
    private String name;
    //@Pattern(regexp="[a-z]*@[a-z]*")
    @Pattern(regexp="^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@" +
		"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String email;
    @Column(nullable=false)
    private Integer rating;
    
    @ManyToOne
    private Post post;

    public Comment() {
    }

    public Comment(String content, String name, String email, Integer rating, Post post) {
        this.content = content;
        this.name = name;
        this.email = email;
        this.rating = rating;
        this.post = post;
    }

    
    /**
     * @return the Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Integer Id) {
        this.id = id;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the rating
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     * @return the post
     */
    public Post getPost() {
        return post;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Comment other = (Comment) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comment{" + "content=" + content + ", name=" + name + ", email=" + email + ", rating=" + rating + ", post=" + post + '}';
    }
    
    
}
