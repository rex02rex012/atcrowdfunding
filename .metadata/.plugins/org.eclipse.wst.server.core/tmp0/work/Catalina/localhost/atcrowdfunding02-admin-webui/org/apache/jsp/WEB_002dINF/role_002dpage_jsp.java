/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.27
 * Generated at: 2023-06-22 08:03:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class role_002dpage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("/WEB-INF/include-nav.jsp", Long.valueOf(1681738997229L));
    _jspx_dependants.put("/WEB-INF/modal-role-confirm.jsp", Long.valueOf(1686477211247L));
    _jspx_dependants.put("/WEB-INF/include-head.jsp", Long.valueOf(1681738997227L));
    _jspx_dependants.put("/WEB-INF/include-sidebar.jsp", Long.valueOf(1686746201386L));
    _jspx_dependants.put("/WEB-INF/modal-role-add.jsp", Long.valueOf(1685277424018L));
    _jspx_dependants.put("/WEB-INF/modal-role-edit.jsp", Long.valueOf(1685774412780L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"\">\r\n");
      out.write("<base\r\n");
      out.write("\thref=\"http://");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.serverName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(':');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.serverPort }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/main.css\">\r\n");
      out.write("<style>\r\n");
      out.write(".tree li {\r\n");
      out.write("\tlist-style-type: none;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".tree-closed {\r\n");
      out.write("\theight: 40px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".tree-expanded {\r\n");
      out.write("\theight: auto;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jquery/jquery-2.1.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"script/docs.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"layer/layer.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$(\".list-group-item\").click(function() {\r\n");
      out.write("\t\t\tif ($(this).find(\"ul\")) {\r\n");
      out.write("\t\t\t\t$(this).toggleClass(\"tree-closed\");\r\n");
      out.write("\t\t\t\tif ($(this).hasClass(\"tree-closed\")) {\r\n");
      out.write("\t\t\t\t\t$(\"ul\", this).hide(\"fast\");\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t$(\"ul\", this).show(\"fast\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<title>尚筹网</title>\r\n");
      out.write("</head>");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/pagination.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"jquery/jquery.pagination.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"crowd/my-role.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 1.為分頁操作準備初始化數據\r\n");
      out.write("\t\twindow.pageNum = 1;\r\n");
      out.write("\t\twindow.pageSize = 5;\r\n");
      out.write("\t\twindow.keyword = \"\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 2.調用執行分頁的函數，顯示分頁效果\r\n");
      out.write("\t\tgeneratePage();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 3.給查詢按鈕綁定單擊響應函數\r\n");
      out.write("\t\t$(\"#searchBtn\").click(function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// ①獲取關鍵詞數據賦值給對應的全局變量\r\n");
      out.write("\t\t\twindow.keyword = $(\"#keywordInput\").val();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// ②調用分頁函數刷新頁面\r\n");
      out.write("\t\t\tgeneratePage();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 4.點擊新增按鈕打開模態框\r\n");
      out.write("\t\t$(\"#showAddModalBtn\").click(function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(\"#addModal\").modal(\"show\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 5.給新增模態框中的保存按鈕綁定單擊響應函數\r\n");
      out.write("\t\t$(\"#saveRoleBtn\").click(function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// ①獲取用戶在文本框中輸入的角色名稱\r\n");
      out.write("\t\t\t// #addModal表示找到整個模態框\r\n");
      out.write("\t\t\t// 空格表示在後代元素中繼續查找\r\n");
      out.write("\t\t\t// [name=roleName]表示匹配name屬性等於roleName的元素\r\n");
      out.write("\t\t\tvar roleName = $.trim($(\"#addModal [name=roleName]\").val());\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// ②發送Ajax請求\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\"url\": \"role/save.json\",\r\n");
      out.write("\t\t\t\t\"type\":\"post\",\r\n");
      out.write("\t\t\t\t\"data\": {\r\n");
      out.write("\t\t\t\t\t\"name\": roleName\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t\"dataType\": \"json\",\r\n");
      out.write("\t\t\t\t\"success\":function(response){\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tvar result = response.result;\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tif(result == \"SUCCESS\") {\r\n");
      out.write("\t\t\t\t\t\tlayer.msg(\"操作成功！\");\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t// 將頁碼定位到最後一頁\r\n");
      out.write("\t\t\t\t\t\twindow.pageNum = 99999999;\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t// 重新加載分頁數據\r\n");
      out.write("\t\t\t\t\t\tgeneratePage();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tif(result == \"FAILED\") {\r\n");
      out.write("\t\t\t\t\t\tlayer.msg(\"操作失敗！\"+response.message);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t\"error\":function(response){\r\n");
      out.write("\t\t\t\t\tlayer.msg(response.status+\" \"+response.statusText);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 關閉模態框\r\n");
      out.write("\t\t\t$(\"#addModal\").modal(\"hide\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 清理模態框\r\n");
      out.write("\t\t\t$(\"#addModal [name=roleName]\").val(\"\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 6.給頁面上的“鉛筆”按鈕綁定單擊響應函數，目的是打開模態框\r\n");
      out.write("\t\t// 傳統的事件綁定方式只能在第一個頁面有效，翻頁後失效了\r\n");
      out.write("\t\t// $(\".pencilBtn\").click(function(){\r\n");
      out.write("\t\t// \talert(\"aaaa...\");\r\n");
      out.write("\t\t// });\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 使用jQuery對象的on()函數可以解決上面問題\r\n");
      out.write("\t\t// ①首先找到所有“動態生成”的元素所附著的“靜態”元素\r\n");
      out.write("\t\t// ②on()函數的第一個參數是事件類型\r\n");
      out.write("\t\t// ③on()函數的第二個參數是找到真正要綁定事件的元素的選擇器\r\n");
      out.write("\t\t// ③on()函數的第三個參數是事件的響應函數\r\n");
      out.write("\t\t$(\"#rolePageBody\").on(\"click\",\".pencilBtn\",function(){\r\n");
      out.write("\t\t\t// 打開模態框\r\n");
      out.write("\t\t\t$(\"#editModal\").modal(\"show\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 獲取表格中當前行中的角色名稱\r\n");
      out.write("\t\t\tvar roleName = $(this).parent().prev().text();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 獲取當前角色的id\r\n");
      out.write("\t\t\t// 依據是：var pencilBtn = \"<button id='\"+roleId+\"' ……這段代碼中我們把roleId設置到id屬性了\r\n");
      out.write("\t\t\t// 為了讓執行更新的按鈕能夠獲取到roleId的值，把它放在全局變量上\r\n");
      out.write("\t\t\twindow.roleId = this.id;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 使用roleName的值設置模態框中的文本框\r\n");
      out.write("\t\t\t$(\"#editModal [name=roleName]\").val(roleName);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 7.給更新模態框中的更新按鈕綁定單擊響應函數\r\n");
      out.write("\t\t$(\"#updateRoleBtn\").click(function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// ①從文本框中獲取新的角色名稱\r\n");
      out.write("\t\t\tvar roleName = $(\"#editModal [name=roleName]\").val();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// ②發送Ajax請求執行更新\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\"url\":\"role/update.json\",\r\n");
      out.write("\t\t\t\t\"type\":\"post\",\r\n");
      out.write("\t\t\t\t\"data\":{\r\n");
      out.write("\t\t\t\t\t\"id\":window.roleId,\r\n");
      out.write("\t\t\t\t\t\"name\":roleName\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t\"dataType\":\"json\",\r\n");
      out.write("\t\t\t\t\"success\":function(response){\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tvar result = response.result;\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tif(result == \"SUCCESS\") {\r\n");
      out.write("\t\t\t\t\t\tlayer.msg(\"操作成功！\");\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t// 重新加載分頁數據\r\n");
      out.write("\t\t\t\t\t\tgeneratePage();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tif(result == \"FAILED\") {\r\n");
      out.write("\t\t\t\t\t\tlayer.msg(\"操作失敗！\"+response.message);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t\"error\":function(response){\r\n");
      out.write("\t\t\t\t\tlayer.msg(response.status+\" \"+response.statusText);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// ③關閉模態框\r\n");
      out.write("\t\t\t$(\"#editModal\").modal(\"hide\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 臨時測試代碼\r\n");
      out.write("\t\t// var roleArray = [{roleId:5,roleName:\"aaa\"},{roleId:5,roleName:\"bbb\"}];\r\n");
      out.write("\t\t// showConfirmModal(roleArray);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 8.點擊確認模態框中的確認刪除按鈕執行刪除\r\n");
      out.write("\t\t$(\"#removeRoleBtn\").click(function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 從全局變量範圍獲取roleIdArray，轉換為JSON字符串\r\n");
      out.write("\t\t\tvar requestBody = JSON.stringify(window.roleIdArray);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\"url\":\"role/remove/by/role/id/array.json\",\r\n");
      out.write("\t\t\t\t\"type\":\"post\",\r\n");
      out.write("\t\t\t\t\"data\":requestBody,\r\n");
      out.write("\t\t\t\t\"contentType\":\"application/json;charset=UTF-8\",\r\n");
      out.write("\t\t\t\t\"dataType\":\"json\",\r\n");
      out.write("\t\t\t\t\"success\":function(response){\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tvar result = response.result;\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tif(result == \"SUCCESS\") {\r\n");
      out.write("\t\t\t\t\t\tlayer.msg(\"操作成功！\");\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t// 重新加載分頁數據\r\n");
      out.write("\t\t\t\t\t\tgeneratePage();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tif(result == \"FAILED\") {\r\n");
      out.write("\t\t\t\t\t\tlayer.msg(\"操作失敗！\"+response.message);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t\"error\":function(response){\r\n");
      out.write("\t\t\t\t\tlayer.msg(response.status+\" \"+response.statusText);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 關閉模態框\r\n");
      out.write("\t\t\t$(\"#confirmModal\").modal(\"hide\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 9.給單條刪除按鈕綁定單擊響應函數\r\n");
      out.write("\t\t$(\"#rolePageBody\").on(\"click\",\".removeBtn\",function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 從當前按鈕出發獲取角色名稱\r\n");
      out.write("\t\t\tvar roleName = $(this).parent().prev().text();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 創建role對象存入數組\r\n");
      out.write("\t\t\tvar roleArray = [{\r\n");
      out.write("\t\t\t\troleId:this.id,\r\n");
      out.write("\t\t\t\troleName:roleName\r\n");
      out.write("\t\t\t}];\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 調用專門的函數打開模態框\r\n");
      out.write("\t\t\tshowConfirmModal(roleArray);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 10.給總的checkbox綁定單擊響應函數\r\n");
      out.write("\t\t$(\"#summaryBox\").click(function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// ①獲取當前多選框自身的狀態\r\n");
      out.write("\t\t\tvar currentStatus = this.checked;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// ②用當前多選框的狀態設置其他多選框\r\n");
      out.write("\t\t\t$(\".itemBox\").prop(\"checked\", currentStatus);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 11.全選、全不選的反向操作\r\n");
      out.write("\t\t$(\"#rolePageBody\").on(\"click\",\".itemBox\",function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 獲取當前已經選中的.itemBox的數量\r\n");
      out.write("\t\t\tvar checkedBoxCount = $(\".itemBox:checked\").length;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 獲取全部.itemBox的數量\r\n");
      out.write("\t\t\tvar totalBoxCount = $(\".itemBox\").length;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 使用二者的比較結果設置總的checkbox\r\n");
      out.write("\t\t\t$(\"#summaryBox\").prop(\"checked\", checkedBoxCount == totalBoxCount);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 12.給批量刪除的按鈕綁定單擊響應函數\r\n");
      out.write("\t\t$(\"#batchRemoveBtn\").click(function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 創建一個數組對象用來存放後面獲取到的角色對象\r\n");
      out.write("\t\t\tvar roleArray = [];\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 遍歷當前選中的多選框\r\n");
      out.write("\t\t\t$(\".itemBox:checked\").each(function(){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t// 使用this引用當前遍歷得到的多選框\r\n");
      out.write("\t\t\t\tvar roleId = this.id;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t// 通過DOM操作獲取角色名稱\r\n");
      out.write("\t\t\t\tvar roleName = $(this).parent().next().text();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\troleArray.push({\r\n");
      out.write("\t\t\t\t\t\"roleId\":roleId,\r\n");
      out.write("\t\t\t\t\t\"roleName\":roleName\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 檢查roleArray的長度是否為0\r\n");
      out.write("\t\t\tif(roleArray.length == 0) {\r\n");
      out.write("\t\t\t\tlayer.msg(\"請至少選擇一個執行刪除\");\r\n");
      out.write("\t\t\t\treturn ;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 調用專門的函數打開模態框\r\n");
      out.write("\t\t\tshowConfirmModal(roleArray);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\r\n");
      out.write("\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<a class=\"navbar-brand\" style=\"font-size: 32px;\" href=\"#\">众筹平台 -\r\n");
      out.write("\t\t\t\t\t控制面板</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"navbar\" class=\"navbar-collapse collapse\">\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t<li style=\"padding-top: 8px;\">\r\n");
      out.write("\t\t\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"btn btn-default btn-success dropdown-toggle\"\r\n");
      out.write("\t\t\t\t\t\t\tdata-toggle=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"glyphicon glyphicon-user\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginAdmin.userName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" <span class=\"caret\"></span>\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"dropdown-menu\" role=\"menu\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"glyphicon glyphicon-cog\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t个人设置</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"glyphicon glyphicon-comment\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t消息</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"divider\"></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"admin/do/logout.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-off\"></i> 退出系统</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li style=\"margin-left: 10px; padding-top: 8px;\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-default btn-danger\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"glyphicon glyphicon-question-sign\"></span> 帮助\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<form class=\"navbar-form navbar-right\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"form-control\" placeholder=\"查询\">\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</nav>");
      out.write("\r\n");
      out.write("\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("<div class=\"col-sm-3 col-md-2 sidebar\">\r\n");
      out.write("\t<div class=\"tree\">\r\n");
      out.write("\t\t<ul style=\"padding-left: 0px;\" class=\"list-group\">\r\n");
      out.write("\t\t\t<li class=\"list-group-item tree-closed\"><a href=\"main.html\"><i\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-dashboard\"></i> 控制面板</a></li>\r\n");
      out.write("\t\t\t<li class=\"list-group-item tree-closed\"><span><i\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon glyphicon-tasks\"></i> 權限管理 <span\r\n");
      out.write("\t\t\t\t\tclass=\"badge\" style=\"float: right\">3</span></span>\r\n");
      out.write("\t\t\t\t<ul style=\"margin-top: 10px; display: none;\">\r\n");
      out.write("\t\t\t\t\t<li style=\"height: 30px;\"><a href=\"admin/get/page.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-user\"></i> 用戶維護</a></li>\r\n");
      out.write("\t\t\t\t\t<li style=\"height: 30px;\"><a href=\"role/to/page.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-king\"></i> 角色維護</a></li>\r\n");
      out.write("\t\t\t\t\t<li style=\"height: 30px;\"><a href=\"menu/to/page.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-lock\"></i> 菜單維護</a></li>\r\n");
      out.write("\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li class=\"list-group-item tree-closed\"><span><i\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-ok\"></i> 業務審核 <span class=\"badge\"\r\n");
      out.write("\t\t\t\t\tstyle=\"float: right\">3</span></span>\r\n");
      out.write("\t\t\t\t<ul style=\"margin-top: 10px; display: none;\">\r\n");
      out.write("\t\t\t\t\t<li style=\"height: 30px;\"><a href=\"auth_cert.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-check\"></i> 實名認證審核</a></li>\r\n");
      out.write("\t\t\t\t\t<li style=\"height: 30px;\"><a href=\"auth_adv.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-check\"></i> 廣告審核</a></li>\r\n");
      out.write("\t\t\t\t\t<li style=\"height: 30px;\"><a href=\"auth_project.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-check\"></i> 項目審核</a></li>\r\n");
      out.write("\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li class=\"list-group-item tree-closed\"><span><i\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-th-large\"></i> 業務管理 <span class=\"badge\"\r\n");
      out.write("\t\t\t\t\tstyle=\"float: right\">7</span></span>\r\n");
      out.write("\t\t\t\t<ul style=\"margin-top: 10px; display: none;\">\r\n");
      out.write("\t\t\t\t\t<li style=\"height: 30px;\"><a href=\"cert.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-picture\"></i> 資質維護</a></li>\r\n");
      out.write("\t\t\t\t\t<li style=\"height: 30px;\"><a href=\"type.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-equalizer\"></i> 分類管理</a></li>\r\n");
      out.write("\t\t\t\t\t<li style=\"height: 30px;\"><a href=\"process.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-random\"></i> 流程管理</a></li>\r\n");
      out.write("\t\t\t\t\t<li style=\"height: 30px;\"><a href=\"advertisement.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-hdd\"></i> 廣告管理</a></li>\r\n");
      out.write("\t\t\t\t\t<li style=\"height: 30px;\"><a href=\"message.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-comment\"></i> 消息模板</a></li>\r\n");
      out.write("\t\t\t\t\t<li style=\"height: 30px;\"><a href=\"project_type.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-list\"></i> 項目分類</a></li>\r\n");
      out.write("\t\t\t\t\t<li style=\"height: 30px;\"><a href=\"tag.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"glyphicon glyphicon-tags\"></i> 項目標簽</a></li>\r\n");
      out.write("\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li class=\"list-group-item tree-closed\"><a href=\"param.html\"><i\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-list-alt\"></i> 參數管理</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\r\n");
      out.write("\t\t\t\t<div class=\"panel panel-default\">\r\n");
      out.write("\t\t\t\t\t<div class=\"panel-heading\">\r\n");
      out.write("\t\t\t\t\t\t<h3 class=\"panel-title\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"glyphicon glyphicon-th\"></i> 數據列表\r\n");
      out.write("\t\t\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t\t\t<form class=\"form-inline\" role=\"form\" style=\"float: left;\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group has-feedback\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"input-group-addon\">查詢條件</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input id=\"keywordInput\" class=\"form-control has-success\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tplaceholder=\"請輸入查詢條件\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<button id=\"searchBtn\" type=\"button\" class=\"btn btn-warning\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"glyphicon glyphicon-search\"></i> 查詢\r\n");
      out.write("\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t<button id=\"batchRemoveBtn\" type=\"button\" class=\"btn btn-danger\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"float: right; margin-left: 10px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\" glyphicon glyphicon-remove\"></i> 刪除\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t<button \r\n");
      out.write("\t\t\t\t\t\t\ttype=\"button\" \r\n");
      out.write("\t\t\t\t\t\t\tid=\"showAddModalBtn\" class=\"btn btn-primary\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"float: right;\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"glyphicon glyphicon-plus\"></i> 新增\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<hr style=\"clear: both;\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"table-responsive\">\r\n");
      out.write("\t\t\t\t\t\t\t<table class=\"table  table-bordered\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th width=\"30\">#</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th width=\"30\"><input id=\"summaryBox\" type=\"checkbox\"></th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th>名稱</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<th width=\"100\">操作</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tbody id=\"rolePageBody\"></tbody>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tfoot>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"6\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div id=\"Pagination\" class=\"pagination\"><!-- 這裏顯示分頁 --></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tfoot>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<div id=\"addModal\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("\t<div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("\t\t\t\t\taria-label=\"Close\">\r\n");
      out.write("\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\">尚籌網系統彈窗</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<form class=\"form-signin\" role=\"form\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group has-success has-feedback\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"roleName\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"inputSuccess4\" placeholder=\"請輸入角色名稱\" autofocus>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<button id=\"saveRoleBtn\" type=\"button\" class=\"btn btn-primary\">\r\n");
      out.write("\t\t\t\t\t保存</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>");
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("<div id=\"editModal\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("\t<div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("\t\t\t\t\taria-label=\"Close\">\r\n");
      out.write("\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\">尚籌網系統彈窗</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<form class=\"form-signin\" role=\"form\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group has-success has-feedback\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"roleName\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\tplaceholder=\"請輸入角色名稱\" autofocus>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<button id=\"updateRoleBtn\" type=\"button\" class=\"btn btn-success\">\r\n");
      out.write("\t\t\t\t\t更新</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>");
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("<div id=\"confirmModal\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("\t<div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("\t\t\t\t\taria-label=\"Close\">\r\n");
      out.write("\t\t\t\t\t<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t<h4 class=\"modal-title\">尚籌網系統彈窗</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<h4>請確認是否要刪除下列角色：</h4>\r\n");
      out.write("\t\t\t\t<div id=\"roleNameDiv\" style=\"text-align: center;\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t<button id=\"removeRoleBtn\" type=\"button\" class=\"btn btn-primary\">確認刪除</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
