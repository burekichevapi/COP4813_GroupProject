package repository;

import java.util.List;
import java.util.ArrayList;
import Domain.Complaint;
import Domain.Post;

public class ComplaintRepository {

    public List<Complaint> getComplaints() {

        List<Complaint> complaints = new ArrayList<>();
        complaints = HibernateHelper.getListData(Complaint.class);

        if (complaints.isEmpty()) {
            return null;
        }

        return complaints;
    }

    public Complaint getComplaintById(int id) {

        List<Complaint> complaints = HibernateHelper.getListData(Complaint.class);
        
        for (Complaint i : complaints) {
            if (i.getComplaintId() == id) {
                return i;
            }
        }
        return null;
    }

    public void addThread(Complaint complaint) {
        HibernateHelper.updateDB(complaint);
    }
}
