package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

public class doHttp extends HttpServlet{
	
	public doHttp() {
		super();
	}
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url=req.getParameter("url");
		ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target("http://localhost:9527/Restservice2");
        String res=" ";
        res=(String) target.path("rest").path("webservice").queryParam("url", url).request().accept(MediaType.TEXT_PLAIN).get(String.class);	
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("        <html>\r\n" + 
        		"    	<meta content=\"text/html;charset=utf-8\"/>	\r\n" + 
        		"    	<head>\r\n" + 
        		"    		<title>邮件验证结果</title>\r\n" + 
        		"    	</head>");
        out.println("    	<body>");
        out.println("    		<h1>" + res + "</h1>");
        out.println("    	</body>\r\n" + 
        		"    </html>");
        out.close();
    }
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
    }

}
