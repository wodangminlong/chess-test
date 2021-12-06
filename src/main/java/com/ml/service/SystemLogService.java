package com.ml.service;

import com.ml.model.SystemLog;

/**
 * @author dml
 * @date 2021/12/6 15:06
 */
public interface SystemLogService {

    /**
     * add log
     *
     * @param systemLog systemLog
     */
    void addLog(SystemLog systemLog);

}
