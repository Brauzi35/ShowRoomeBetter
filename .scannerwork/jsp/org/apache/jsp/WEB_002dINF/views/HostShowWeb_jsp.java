/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspC/ApacheTomcat9
 * Generated at: 2021-07-16 15:45:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import logic.engclasses.utils.Session;
import logic.engclasses.bean.LoggedBean;

public final class HostShowWeb_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("logic.engclasses.bean.LoggedBean");
    _jspx_imports_classes.add("logic.engclasses.utils.Session");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write(" \r\n            \r\n    \r\n    \r\n    ");

    String artist = (String)session.getAttribute("artistNameSponsor");
    Session smhs = (Session)session.getAttribute("session");
	LoggedBean ss = smhs.getLoggedBean();
	String username = ss.getUsername();
    
      out.write("\r\n \r\n<!DOCTYPE html>\r\n<html  lang=\"it\">\r\n  <head>\r\n    <title>Prova</title>\r\n  </head>\r\n  <body style=\" height: 512px; background-color: white;\"><img src=\"https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/26362.png?raw=true\"\r\n\r\n \r\n\r\n      alt=\"\" style=\"width: 93px; height: 73px; margin-left: -2px;\"><br>\r\n   \r\n    <h1 style=\"margin-top: -45.5667px; margin-left: 115px;\">  ShowRoome Sponsor</h1>  \r\n     <h1 style=\"margin-top:84px;margin-left:3px;\">\r\n      <form action=\"TastoProfile\" method=\"post\">\r\n        <p style=\"margin-top:-74px;margin-left:400px;\"><input id=\"Submit\" name=\"Profile\" type=\"submit\" value=\"Organizza\"  style=\"height: 35px; width: 95px; margin-top: -48px; margin-left: 160px;background-color: #4D4D4D;color:white;\"></input></p>\r\n      </form>\r\n      \r\n    \r\n      <form action=\"Homepage\" method=\"post\">\r\n        <p style=\"margin-top:-74px;margin-left:-555px;\"><input id=\"Submit\" type=\"submit\" name=\"Homepage\" value=\"Homepage\" style=\"height: 35px ; width: 95px; margin-top: -46px; margin-left: 570px; background-color: #4D4D4D;\"></input>\r\n");
      out.write("        </p>\r\n      </form>\r\n      <form action=\"HostShowWebController\" method=\"get\">\r\n        <p style=\"margin-top:-74px;margin-left:937px;\"><input id=\"Submit\" type=\"submit\" name=\"Setting\" value=\"Request\" style=\"height: 35px ; width: 95px; margin-top: -48px; margin-left: 210px;background-color: #4D4D4D;\"></input></p>\r\n      </form>\r\n    </h1>\r\n    <h1 style=\"margin-top: -74px;margin-left:px ;background-color: white;\">\r\n      <style>\r\n#rectangle {\r\n    width: 1250px;\r\n    height: 50px;\r\n    background: #10030F;\r\n}\r\n</style> <div id=\"rectangle\"></div>\r\n    </h1>\r\n      <h1 style=\"margin-top: -159px; margin-left: 1100px;\"> <input value=");
      out.print(username );
      out.write(" size=\"65\" maxlength=\"40\" ;style=\"background-color:\" #10030f=\"\" type=\"submit\"> </h1>\r\n         <form action=\"Logout\" method=\"post\">          <h1 style=\"margin-left: 1190px;margin-top: -57px;\" > <input value=\"logout\" size=\"65\" maxlength=\"40\" ;style=\"background-color:\" #10030f=\"\" type=\"submit\"> </h1></form> \r\n    <h1 style=\"margin-top: 140px;\">Stai contattando ");
      out.print( artist );
      out.write("</h1>\r\n     <p style=\"margin-top: 210px; margin-left: 5px;\"> <img alt=\"\" src=\"https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/1019.jpg?raw=true\"   h1=\"\" style=\"width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;\">\r\n    </p>\r\n     <form action=\"TastoProfile\" method=\"post\">\r\n        <p style=\"margin-top:-30px;margin-left:900px;\"><input id=\"Submit\" name=\"Profile\" type=\"submit\" value=\"Indietro\"  style=\"height: 35px; width: 95px; margin-top: -48px; margin-left: 160px;background-color: #4D4D4D;\"></input></p>\r\n      </form>\r\n    \r\n   <p     style=\"margin-top: -140px; margin-left: 600px;\"  >\r\n         <form action=\"HostShowWebController\" method=\"post\">\r\n\r\n <h3 style=\"margin-top: -180px; margin-left: 580px;\">  Compila richiesta:  </h3>\r\n<ul>\r\n  <li  style=\" list-style-type:none;\">\r\n      <h3 style=\" margin-top: px;margin-left: 500px;\">\r\n        <ul>\r\n          <textarea  value=\"titolo\" id=\"titolo\" name=\"titolo\" style=\"height: 25px; width: 300px; resize: none;\">titolo</textarea>\r\n        </ul>\r\n");
      out.write("        <ul>\r\n          <textarea  value=\"descrizione\" id=\"descrizione\" name=\"descrizione\" style=\"height: 80px; width: 300px; resize: none;\" >descrizione</textarea>\r\n        </ul>\r\n        <ul>\r\n          <input value=\"");
      out.print( artist );
      out.write("\" id=\"artista\" name=\"artista\" style=\"display:none; height: 25px; width: 300px;\" type=\"text\">\r\n            \r\n        </ul>\r\n        \r\n           \r\n      </h3>\r\n    </li>\r\n   </ul>\r\n    <input id=\"Submit\" name=\"Profile\" type=\"submit\" value=\"Invia richiesta\"  style=\"height: 35px; width: 95px; margin-top: 80px; margin-left: 650px;background-color: #4D4D4D;\"></input>\r\n   \r\n   </p>\r\n   \r\n   \r\n   \r\n   </form>\r\n   \r\n   \r\n   \r\n   \r\n   \r\n   \r\n  </body>\r\n</html>\r\n   \r\n   ");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
