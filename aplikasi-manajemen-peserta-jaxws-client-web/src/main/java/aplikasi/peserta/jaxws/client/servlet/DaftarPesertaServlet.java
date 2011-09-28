/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.peserta.jaxws.client.servlet;

import aplikasi.peserta.ManajemenPesertaWS_Service;
import aplikasi.peserta.Peserta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Student-03
 */
public class DaftarPesertaServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/aplikasi-manajemen-peserta-jaxws/ManajemenPesertaWS.wsdl")
    private ManajemenPesertaWS_Service service;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Daftar Peserta</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Daftar Peserta</h1>");
            
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr><th>No. Peserta</th><th>Nama Peserta</th></tr>");
            out.println("</thead>");
            out.println("<tbody>");            

            java.util.List<java.lang.Object> result = querySemuaPeserta();

            for (Object p : result) {
                Peserta peserta = (Peserta) p;
                out.println("<tr><td>"+peserta.getNomerPeserta()
                        +"</td><td>"+peserta.getNama()+"</td></tr>");
            
            }
            
            result.size();
            
            out.println("</tbody>");
            out.println("</table>");

            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    private List<Object> querySemuaPeserta() {
        try { // Call Web Service Operation
            aplikasi.peserta.ManajemenPesertaWS port = service.getManajemenPesertaWSPort();
            // TODO initialize WS operation arguments here
            java.lang.Integer start = Integer.valueOf(0);
            java.lang.Integer rows = Integer.valueOf(0);
            // TODO process result here
            java.util.List<java.lang.Object> result = port.findSemuaPeserta(start, rows);
            return result;
        } catch (Exception ex) {
        // TODO handle custom exceptions here
            ex.printStackTrace();
        }
        return new ArrayList<Object>();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
