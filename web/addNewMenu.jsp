<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>เพิ่มเมนู</h2>
<form action="AddNewMenuMySQL">
    <table>
        <tr><td>ชื่อ:</td><td><input type="text" name="menuName"></td>
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
        <tr><td>ราคา:</td><td><input type="text" name="price">บาท</td></tr>
        <tr><td>&nbsp;</td><td><input type="submit" value="เพิ่มเมนู"></td></tr>
    </table>
</form>