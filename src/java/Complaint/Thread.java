
package Complaint;

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
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int id_;
    
    @Column(name = "USER", nullable = false)
    private Account userAccount_;
    
    @Column(name = "TITLE", nullable = false)
    private String complaintTitle_;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE", nullable = false, insertable = false)
    private Date dateCreated_;
    
    public Account getAccount() {
        return this.userAccount_;
    } 
    
    public void SetAccount(Account account) {
        this.userAccount_ = account;
    }
    
    public String getComplaintTitle() {
        return this.complaintTitle_;
    }
    
    public void setComplaintTitle(String complaintTitle) {
        this.complaintTitle_ = complaintTitle;
    }
}
