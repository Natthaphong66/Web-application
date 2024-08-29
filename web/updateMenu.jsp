<<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Menu" %>

<h2>แก้ไขเมนู</h2>

<%
    Menu menu = (Menu) session.getAttribute("menu");
    out.println("ข้อมูลเดิม: " + menu.getName() + ", " + menu.getType()+ " , " + menu.getSweetlevel() + "," + menu.getPrice()); 
%>

<form action="AddNewMenuMySQL">
    <table>
        <tr><td>ชื่อ:</td>
            <td><input type="text" name="menuName" value="<%= menu.getName() %>"></td>
        <tr><td>ประเภท:</td>
            <td>
                <select name="menuType">
                    <option value="ร้อน">ร้อน</option>
                    <option value="เย็น">เย็น</option>
                    <option value="ปั่น">ปั่น</option>  
                </select>
            </td>
        </tr>
        <tr><td>ระดับความหวาน:</td>
            <td>
                <input type="radio" name="sweetlevel" value="ไม่หวาน">ไม่หวาน
                <input type="radio" name="sweetlevel" value="หวานน้อย">หวานน้อย
                <input type="radio" name="sweetlevel" value="หวานปกติ">หวานปกติ
            </td>
        </tr>
        <tr><td>ราคา:</td><td><input type="text" name="price" value="<%= menu.getPrice() %>">บาท</td></tr>
        <tr><td>&nbsp;</td><td><input type="submit" value="เพิ่มเมนู"></td></tr>
    </table>
</form>
        
<% session.removeAttribute("menu"); %>