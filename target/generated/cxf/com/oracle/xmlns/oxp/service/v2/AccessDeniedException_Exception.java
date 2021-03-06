
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.0.7
 * 2019-01-05T23:42:13.532+05:30
 * Generated source version: 3.0.7
 */

@WebFault(name = "fault", targetNamespace = "http://xmlns.oracle.com/oxp/service/v2")
public class AccessDeniedException_Exception extends Exception {
    
    private com.oracle.xmlns.oxp.service.v2.AccessDeniedException fault;

    public AccessDeniedException_Exception() {
        super();
    }
    
    public AccessDeniedException_Exception(String message) {
        super(message);
    }
    
    public AccessDeniedException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessDeniedException_Exception(String message, com.oracle.xmlns.oxp.service.v2.AccessDeniedException fault) {
        super(message);
        this.fault = fault;
    }

    public AccessDeniedException_Exception(String message, com.oracle.xmlns.oxp.service.v2.AccessDeniedException fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public com.oracle.xmlns.oxp.service.v2.AccessDeniedException getFaultInfo() {
        return this.fault;
    }
}
