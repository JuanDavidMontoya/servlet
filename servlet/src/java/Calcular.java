/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alejo
 */
@WebServlet(urlPatterns = {"/Calcular"})
public class Calcular extends HttpServlet {

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
        
        
        try (PrintWriter out = response.getWriter()) {

            String Numeros = request.getParameter("lista");
            
            String[] ListaValores;
            double prom = 0; 
            double cant = 0;
            double suma = 0;
            int moda = 0;
            int Repeticiones = 0;


            ListaValores = Numeros.split(",");
            
            List<Integer> valores = new ArrayList<>();
            for (int i=0; i<ListaValores.length; i++) {
                
                valores.add(Integer.parseInt(ListaValores[i]));
            }//fin del primer for

            
            for (int y=0; y<valores.size(); y++) {

                suma += valores.get(y);
                cant = y+1;
                prom = suma / cant;
            }//fin del segundo for

            
            for (int z=0; z<valores.size(); z++) {
                
                int Repeticiones2 = 0;
                
                for (int x=0; x < valores.size(); x++) {
                    
                    if (valores.get(z) == valores.get(x)) {
                        Repeticiones2++;
                    }
                    if (Repeticiones < Repeticiones2) {
                        moda = valores.get(z);
                        Repeticiones = Repeticiones2;
                    }//fin del cuarto for
                }//fin del quinto for
            } response.sendRedirect("resultado.jsp?media=" + prom + "&moda=" + moda);
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
