package com.github.duychuongvn.logging.dao.repository;

import com.github.duychuongvn.logging.dao.entity.LogRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRecordRepository extends JpaRepository<LogRecord, String> {
}
