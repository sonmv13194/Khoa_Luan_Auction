package vn.smartdev.logging;

import vn.smartdev.logging.dao.entity.LogDetails;
import vn.smartdev.logging.dao.entity.LogLevel;
import vn.smartdev.logging.dao.entity.LogRecord;
import vn.smartdev.logging.dao.repository.LogDetailsRepository;
import vn.smartdev.logging.dao.repository.LogRecordRepository;

import java.util.List;

public abstract class AbstractLogManager implements LogManager {
    private LogRecordRepository logRecordRepository;
    private LogDetailsRepository logDetailsRepository;

    @Override
    public void finishLog() {

        LogCache logCache = LoggingContextHolder.getLogCache();
        LogRecord logRecord = logCache.getLogRecord();
        List<LogDetails> logDetailses = logCache.getLogDetails();
        for (LogDetails details : logDetailses) {
            if (details.getLevel() == LogLevel.ERROR || (details.getLevel() == LogLevel.FATAL)) {
                logRecord.setLevel(LogLevel.ERROR);
                break;
            }
        }

        logRecordRepository.saveAndFlush(logRecord);
        logDetailsRepository.save(logDetailses);
    }
}
