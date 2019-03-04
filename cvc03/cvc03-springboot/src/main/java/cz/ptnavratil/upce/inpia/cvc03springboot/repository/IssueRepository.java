package cz.ptnavratil.upce.inpia.cvc03springboot.repository;

import cz.ptnavratil.upce.inpia.cvc03springboot.dao.IssueReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<IssueReport,Long> {
}
