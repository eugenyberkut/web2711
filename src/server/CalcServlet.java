package server;

import logic.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Yevhen on 27.11.2015.
 */
@WebServlet(name = "CalcServlet", urlPatterns = {"/calculate"})
public class CalcServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sa = request.getParameter("a");
        String sb = request.getParameter("b");
        int a = Integer.parseInt(sa);
        int b = Integer.parseInt(sb);
        Calculator calc = new Calculator(a,b);
        request.setAttribute("calc",calc);
        request.getRequestDispatcher("/calc.jsp").forward(request,response);
    }
}
