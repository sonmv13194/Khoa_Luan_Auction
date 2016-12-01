package vn.smartdev.logging;

import vn.smartdev.logging.dao.entity.LogDetails;
import vn.smartdev.logging.dao.entity.LogLevel;

public class LoggingContextHolder {
    private static ThreadLocal<LogCache> logCacheThreadLocal = new InheritableThreadLocal<>();


    public static void setLogCache(LogCache logCache) {
        logCacheThreadLocal.set(logCache);
    }

    public static LogCache getLogCache() {
        return logCacheThreadLocal.get();
    }

    public void addLogDetail(LogDetails logDetails) {
        LogCache logCache = getLogCache();
        logCache.getLogDetails().add(logDetails);
    }

    public void log(LogLevel logLevel, String message) {
        LogCache logCache = getLogCache();
        LogDetails logDetails = new LogDetails();
        logDetails.setLevel(logLevel);
        logDetails.setContent(message);
        logDetails.setLogRecordId(logCache.getLogRecord().getId());
        logCache.getLogDetails().add(logDetails);
    }
    public static void clear() {
        logCacheThreadLocal.remove();
    }

}
