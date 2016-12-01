package vn.smartdev.logging.dao.repository;

import vn.smartdev.logging.dao.entity.LogRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRecordRepository extends JpaRepository<LogRecord, String> {
}
