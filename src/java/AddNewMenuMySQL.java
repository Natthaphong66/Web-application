/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import controller.DBConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Menu;
/**
 *
 * @author HP
 */
@WebServlet(urlPatterns = {"/AddNewMenuMySQL"})
public class AddNewMenuMySQL extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // get parameters
        String menuName = request.getParameter("menuName");
        String menuType = request.getParameter("menuType");
        String sweetlevel = request.getParameter("sweetlevel");
        int price = Integer.parseInt(request.getParameter("price"));

        // create an instance of Food
        Menu menu = new Menu();
        menu.setName(menuName);
        menu.setType(menuType);
        menu.setSweetlevel(sweetlevel);
        menu.setPrice(price);

        // insert into MySQL: table food
        DBConnection dbConnection = new DBConnection();
        if(!dbConnection.insertNewMenu(menu)){
            System.out.println(">>> AddNewMenuMySQL ERROR");
        }

        // forward to addNewFoodSuccess.jsp
        HttpSession session = request.getSession();
        session.setAttribute("menu", menu);
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/addNewMenuSuccess.jsp");
        rd.forward(request, response);

    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
