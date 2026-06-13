package com.amin.e_commerce.core.logging.audit;

import com.amin.e_commerce.core.constant.SystemDomain;
import com.amin.e_commerce.core.logging.definition.SystemOperationType;
import com.amin.e_commerce.core.logging.definition.SystemOperation;

public interface SystemOperationLogger {

    void started(SystemOperation operation, SystemOperationType type, SystemDomain domain);

    void completed(SystemOperation operation, SystemOperationType type, SystemDomain domain);

    void failed(SystemOperation operation, SystemOperationType type, SystemDomain domain, Exception ex);

    //void skipped(SystemOperation operation, String reason);

}
