/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package converter.web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import converter.ejb.ConverterBean;

@WebServlet(name = "ConverterServlet", urlPatterns = {"/ConverterServlet"})
public class ConverterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private ConverterBean cb = new ConverterBean();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        // Output the results
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Temperature Converter</title>");
        out.println("</head>");
        out.println("<body> ");
        out.println("<h1>Temperature Converter Reamur - Kelvin</h1>");
        out.println("<h2>Tugas Kelompok 33 Shift 5</h2>");
        try {
            String degree = request.getParameter("degree");
            if ((degree != null) && (degree.length() > 0)) {
                double d = Double.parseDouble(degree);
                if (request.getParameter("R TO K") != null) {
                    String kelvin = cb.rtok(d);
                    out.println("<p><font color=\"red\">" + degree + " Reamur</font> are <font color=\"blue\">" + kelvin + " Kelvin</font>.</p>");
                }
                if (request.getParameter("K TO R") != null) {
                    String reamur = cb.ktor(d);
                    out.println("<p><font color=\"red\">" + degree + " Kelvin</font> are <font color=\"blue\">" + reamur + " Reamur</font>.</p>");
                }
            } else {
                out.println("<p>Enter degree to convert:</p>");
                out.println("<form method=\"get\" >");
                out.println("<p> <input type=\"text\" name=\"degree\" size=\"25\"></p>");
                out.println("<input type=\"submit\" name=\"R TO K\" value=\"R TO K\" style=\"background-color: #00FFFF;\">");
                out.println("<input type=\"submit\" name=\"K TO R\" value=\"K TO R\" style=\"background-color: #4CAF50;\">");
                out.println("</form>");
            }
        } finally {
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
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
