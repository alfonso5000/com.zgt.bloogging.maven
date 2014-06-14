package org.bloogging.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Author implements Serializable {
    @Id
    private String username;
    private String password;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE} )
    private Group group;

    public Author() {
    }

    public Author(String username, String password, Group group) {
        this.username = username;
        this.password = password;
        this.group = group;
    }
    
  
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the group
     */
    public Group getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.username);
        hash = 29 * hash + Objects.hashCode(this.group);
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
        final Author other = (Author) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.group, other.group)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Author{" + "username=" + username + ", group=" + group + '}';
    }

     
}
