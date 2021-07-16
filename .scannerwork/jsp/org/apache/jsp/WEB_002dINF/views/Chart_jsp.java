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
import logic.controller.appcontroller.ReviewAnArtist;
import logic.engclasses.bean.ReviewBean;
import java.util.List;
import logic.engclasses.utils.Session;
import logic.engclasses.bean.LoggedBean;

public final class Chart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("logic.engclasses.bean.ReviewBean");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("logic.engclasses.bean.LoggedBean");
    _jspx_imports_classes.add("logic.controller.appcontroller.ReviewAnArtist");
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

      out.write("\r\n    \r\n    \r\n    \r\n    \r\n    \r\n    \r\n    ");


    String strParam = (String)session.getAttribute("artist2");
    ReviewAnArtist rc = new ReviewAnArtist();
    List<ReviewBean> lrb = rc.getReviews(strParam); //lrb contains every review for a specified artist
    String review1 = "";
    String review2 = "";
    String review3= "";
    Session ch = (Session)session.getAttribute("session");
    LoggedBean lbch = ch.getLoggedBean();
    String username = lbch.getUsername();
    
      out.write("\r\n<!DOCTYPE html>\r\n<html  lang=\"it\">\r\n  <head>\r\n    <title>ShoowRome</title>\r\n  </head>\r\n  <body style=\" height: 512px; background-color: white;\"><img src=\"https://github.com/Brauzi35/ShowRoome-ISPW2021/blob/main/Immagini/26362.png?raw=true\"\r\n\r\n      alt=\"\" style=\"width: 93px; height: 73px; margin-left: -2px;\"><br>\r\n    <h1 style=\"margin-top: -45.5667px; margin-left: 115px;\"> ShowRoome </h1>\r\n     \r\n    <h1 style=\"margin-top:84px;margin-left:3px;\">\r\n     \r\n      <form action=\"TastoChart\" method=\"post\">\r\n        <p style=\"margin-top:-74px;margin-left:170px;\"><input id=\"Submit\" name=\"Chart\" type=\"submit\" value=\"Chart\" \" style=\"height: 35px ; width: 95px; margin-top: -48px; margin-left: 400px;color:white;background-color: #4D4D4D;\"></input>\r\n        </p>\r\n      </form>\r\n      <form action=\"TastoMap\" method=\"post\">\r\n        <p style=\"margin-top:-74px;margin-left:-170px;\"><input id=\"Submit\" name=\"Map\" type=\"submit\" value=\"Homepage\"  style=\"height: 35px ; width: 95px; margin-top: -48px; margin-left: 175px; background-color: #4D4D4D;\"></input>\r\n");
      out.write("        </p>\r\n      </form>\r\n      \r\n      </form>\r\n      <form action=\"HostShowWebController\" method=\"get\">\r\n        <p style=\"margin-top:-74px;margin-left:937px;\"><input id=\"Submit\" type=\"submit\" name=\"Setting\" value=\"Sponsored\" style=\"height: 35px ; width: 95px; margin-top: -48px; margin-left: 210px;background-color: #4D4D4D;\"></input></p>\r\n      </form>\r\n    </h1>\r\n    <h1 style=\"margin-top: -74px;margin-left:px ;background-color: white;\">\r\n      <style>\r\n#rectangle {\r\n    width: 1250px;\r\n    height: 50px;\r\n    background: #10030F;\r\n}\r\n</style> <div id=\"rectangle\"></div>\r\n    </h1>\r\n                  <h1 style=\"margin-top: -159px; margin-left: 1100px;\"> <input value=");
      out.print(username );
      out.write(" size=\"65\" maxlength=\"40\" ;style=\"background-color:\" #10030f=\"\" type=\"submit\"> </h1>\r\n             <form action=\"Logout\" method=\"post\">          <h1 style=\"margin-left: 1190px;margin-top: -57px;\" > <input value=\"logout\" size=\"65\" maxlength=\"40\" ;style=\"background-color:\" #10030f=\"\" type=\"submit\"> </h1></form> \r\n    \r\n    <!-- Primo artista  -->\r\n   \r\n       <p style=\"margin-top: 280px; margin-left: 5px;\"> <img alt=\"\" src=\"https://www.focusjunior.it/content/uploads/2018/10/Michelangelo-Buonarroti.jpg\"\r\n\r\n        style=\"width: 235px; height: 155px; margin-left: -4px; margin-top: -357px;\">\r\n    </p>\r\n  <li style=\"list-style: none\"> <h3 style=\" margin-top: -135px;margin-left: 300px;\"><ul>\r\n    ");
 
    //intuizione assoluta
    try{
      review1 = lrb.get(0).getReview();
     } catch (Exception e){
    	 review1 = "no review found";
     }
     

    try{
      review2 = lrb.get(1).getReview();
     } catch (Exception e){
    	 review2 = "no review found";
     }
    
    
    try{
        review3 = lrb.get(2).getReview();
       } catch (Exception e){
      	 review3 = "no review found";
       }
    	 
    	 
      out.write("\r\n     <textarea readonly=\"readonly\"   style=\"width: 400px; height: 60px; resize: none;\"  form=\"Descrizione artista\">");
      out.print( review1 );
      out.write("</textarea > </ul>\r\n     <ul><textarea readonly=\"readonly\"   style=\"width: 400px; height: 60px; resize: none;\" form=\"Descrizione artista\">");
      out.print(review2 );
      out.write("</textarea></ul>\r\n     <ul><textarea readonly=\"readonly\"   style=\"width: 400px; height: 60px; resize: none;\" form=\"Descrizione artista\">");
      out.print(review3 );
      out.write("</textarea></ul></h3></li>\r\n  <form action=\"SubmitReview\" method=\"post\" style=\" margin-top: -150px;\"\"> <textarea id=\"story\" name=\"story\" style=\" margin-left: 950px;resize: none ;\"rows=\"5\" cols=\"33\">\r\nIt was a dark and stormy night...\r\n</textarea> <button name=\"Dona\" style=\"height: 35px; width: 90px; margin-top: -150px; margin-left: 1030px; background-color: #4d4d4d;\">Recensisci</button> </form>\r\n  <form action=\"test\" method=\"post\">   <button  disabled=\"true\" name=\"Informazioni\" style=\"height: 35px; width: 90px; margin-top: 20px; margin-left: 480px; background-color: #4d4d4d;\">Vedi altre</button></form>\r\n\r\n    \r\n      </form>\r\n  \r\n  </body>\r\n</html>\r\n\r\n");
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
