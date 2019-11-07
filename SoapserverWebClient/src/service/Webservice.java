/**
 * Webservice.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package service;

public interface Webservice extends java.rmi.Remote {
    public java.lang.String validateEmailAddress(java.lang.String _url) throws java.rmi.RemoteException;
    public void sendMail(java.lang.String urls, java.lang.String subject, java.lang.String content) throws java.rmi.RemoteException;
}
