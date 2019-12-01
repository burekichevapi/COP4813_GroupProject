package repository;

import java.util.List;
import java.util.ArrayList;
import Domain.Complaint;

public class ComplaintRepository {

    public List<Complaint> getComplaints() {

        List<Complaint> complaints = new ArrayList<>();
        complaints = HibernateHelper.getListData(Complaint.class);
        
        if (complaints.isEmpty())
            return null;
        
        return complaints;
    }

    public void addThread(Complaint complaint) {
        HibernateHelper.updateDB(complaint);
    }
}
