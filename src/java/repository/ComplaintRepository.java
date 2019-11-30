package repository;

import java.util.List;
import java.util.ArrayList;
import Domain.Complaint;

public class ComplaintRepository {

    public List<Complaint> getComplaints() {

        List<Complaint> complaints = HibernateHelper.getListData(Complaint.class);
        return complaints;
    }

    public void addThread(Complaint complaint) {
        HibernateHelper.updateDB(complaint);
    }
}
