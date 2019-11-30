package Controllers.Post;

import Domain.Account;

public class PostDTO {

    private int complaintId_;
    private String postBody_;
    private Account account_;

    public int getComplaintId() {
        return this.complaintId_;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId_ = complaintId;
    }

    public Account getUser() {
        return this.account_;
    }

    public void setUser(Account user) {
        this.account_ = user;
    }

    public String getPostBody() {
        return this.postBody_;
    }

    public void setPostBody(String postBody) {
        this.postBody_ = postBody;
    }

}
