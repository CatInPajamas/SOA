package service;

public class WebserviceProxy implements service.Webservice {
  private String _endpoint = null;
  private service.Webservice webservice = null;
  
  public WebserviceProxy() {
    _initWebserviceProxy();
  }
  
  public WebserviceProxy(String endpoint) {
    _endpoint = endpoint;
    _initWebserviceProxy();
  }
  
  private void _initWebserviceProxy() {
    try {
      webservice = (new service.WebserviceServiceLocator()).getwebservice();
      if (webservice != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)webservice)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)webservice)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (webservice != null)
      ((javax.xml.rpc.Stub)webservice)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public service.Webservice getWebservice() {
    if (webservice == null)
      _initWebserviceProxy();
    return webservice;
  }
  
  public java.lang.String validateEmailAddress(java.lang.String _url) throws java.rmi.RemoteException{
    if (webservice == null)
      _initWebserviceProxy();
    return webservice.validateEmailAddress(_url);
  }
  
  public void sendMail(java.lang.String urls, java.lang.String subject, java.lang.String content) throws java.rmi.RemoteException{
    if (webservice == null)
      _initWebserviceProxy();
    webservice.sendMail(urls, subject, content);
  }
  
  
}