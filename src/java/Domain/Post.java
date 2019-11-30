package Domain;

import Domain.Complaint;
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
    private Integer id_;

    @Column(name = "COMPLAINTID", nullable = false)
    private int complaintId_;

    @Column(name = "USER", nullable = false)
    private String username_;

    @Column(name = "DATE_CREATED", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreated_;
    
    @Column(name = "BODY", nullable = false)
    private String postBody_;
    
    public int getComplaintId() {
        return this.complaintId_;
    }
    
    public void setComplaintId(int complaintId) {
        this.complaintId_ = complaintId;
    }
    
    public String getUser() {
        return this.username_;
    }
    
    public void setUser(String username) {
        this.username_ = username;
    }
       
    public Date getDate() {
        return this.dateCreated_;
    }
    
    public void setDate(Date date) {
        this.dateCreated_ = date;
    }
    
    public String getPostBody() {
        return this.postBody_;
    }
    
    public void setPostBody(String postBody) {
        this.postBody_ = postBody;
    }           
}

