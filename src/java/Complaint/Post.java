package Complaint;

import Domain.Account;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "THREAD", nullable = false)
    private Thread thread_;

    @Column(name = "USER", nullable = false)
    private Account userAccount_;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE", nullable = false, insertable = false)
    private Date dateCreated_;
    
    @Column(name = "TITLE", nullable = true)
    private String postTitle_;
    
    @Column(name = "BODY", nullable = false)
    private String postBody_;
    
    public Thread getThread() {
        return this.thread_;
    }
    
    public void setThread(Thread thread) {
        this.thread_ = thread;
    }
    
    public Account getUser() {
        return this.userAccount_;
    }
    
    public void setUser(Account user) {
        this.userAccount_ = user;
    }
    
    public String getTitle() {
        return this.postTitle_;
    }
    
    public void setTitle(String title) {
        this.postTitle_ = title;
    }
    
    public Date getDate() {
        return this.dateCreated_;
    }
    
    public void setDate(Date date) {
        this.dateCreated_ = date;
    }
            
}

