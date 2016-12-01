package vn.smartdev.logging.dao.repository;

import vn.smartdev.logging.dao.entity.LogDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogDetailsRepository extends JpaRepository<LogDetails, String> {
}
