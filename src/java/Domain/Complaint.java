
package Domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import Domain.Account;

@Entity
public class Complaint {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int id_;
    
    @Column(name = "USER", nullable = false)
    private String username_;
    
    @Column(name = "TITLE", nullable = false)
    private String complaintTitle_;
    
    @Column(name = "DATE", nullable = false)
    private Date dateCreated_;
    
    public int getComplaintId() {
        return this.id_;
    }
    
    public String getAccount() {
        return this.username_;
    } 
    
    public void setAccount(String username) {
        this.username_ = username;
    }
    
    public String getComplaintTitle() {
        return this.complaintTitle_;
    }
    
    public void setComplaintTitle(String complaintTitle) {
        this.complaintTitle_ = complaintTitle;
    }
    
    public Date getDate() {
        return this.dateCreated_;
    }
    
    public void setDate(Date date) {
        this.dateCreated_ = date;
    }
}
