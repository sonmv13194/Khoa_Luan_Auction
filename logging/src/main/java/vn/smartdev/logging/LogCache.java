package vn.smartdev.logging;

import vn.smartdev.logging.dao.entity.LogDetails;
import vn.smartdev.logging.dao.entity.LogRecord;

import java.util.ArrayList;
import java.util.List;

public class LogCache {

    private LogRecord logRecord;
    private List<LogDetails> logDetails = new ArrayList<>();

    public LogCache(LogRecord logRecord) {
        this.logRecord = logRecord;
    }

    public LogRecord getLogRecord() {
        return logRecord;
    }

    public List<LogDetails> getLogDetails() {
        return logDetails;
    }
}
