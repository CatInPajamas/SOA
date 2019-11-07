<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleWebserviceProxyid" scope="session" class="service.WebserviceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleWebserviceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleWebserviceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleWebserviceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        service.Webservice getWebservice10mtemp = sampleWebserviceProxyid.getWebservice();
if(getWebservice10mtemp == null){
%>
<%=getWebservice10mtemp %>
<%
}else{
        if(getWebservice10mtemp!= null){
        String tempreturnp11 = getWebservice10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String _url_1id=  request.getParameter("_url16");
            java.lang.String _url_1idTemp = null;
        if(!_url_1id.equals("")){
         _url_1idTemp  = _url_1id;
        }
        java.lang.String validateEmailAddress13mtemp = sampleWebserviceProxyid.validateEmailAddress(_url_1idTemp);
if(validateEmailAddress13mtemp == null){
%>
<%=validateEmailAddress13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validateEmailAddress13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
case 18:
        gotMethod = true;
        String urls_2id=  request.getParameter("urls21");
            java.lang.String urls_2idTemp = null;
        if(!urls_2id.equals("")){
         urls_2idTemp  = urls_2id;
        }
        String subject_3id=  request.getParameter("subject23");
            java.lang.String subject_3idTemp = null;
        if(!subject_3id.equals("")){
         subject_3idTemp  = subject_3id;
        }
        String content_4id=  request.getParameter("content25");
            java.lang.String content_4idTemp = null;
        if(!content_4id.equals("")){
         content_4idTemp  = content_4id;
        }
        sampleWebserviceProxyid.sendMail(urls_2idTemp,subject_3idTemp,content_4idTemp);
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>