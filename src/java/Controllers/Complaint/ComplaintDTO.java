package Controllers.Complaint;

import Domain.Account;

public class ComplaintDTO {

    private int complaintId_;
    private Account account_;
    private String complaintTitle_;

    public int getComplaintId() {
        return this.complaintId_;
    }

    public Account getAccount() {
        return this.account_;
    }

    public void SetAccount(Account account) {
        this.account_ = account;
    }

    public String getComplaintTitle() {
        return this.complaintTitle_;
    }

    public void setComplaintTitle(String complaintTitle) {
        this.complaintTitle_ = complaintTitle;
    }
}
