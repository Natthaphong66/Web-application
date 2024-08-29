<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Menu" %>
<table>
<h2>เพิ่มเมนูสำเร็จ</h2>
<%
     Menu menu = (Menu) session.getAttribute("menu");
%>
ชื่อ: <%= menu.getName() %><br/>
ประเภท: <%= menu.getType() %><br/>
ระดับความหวาน: <%= menu.getSweetlevel() %><br/>
ราคา: <%= menu.getPrice() %>บาท<br/>
 <a href="updateMenu.jsp">แก้ไขข้อมูลเมนู</a>
</table>
