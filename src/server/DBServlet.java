package server;

import tables.Avtor;
import tables.Book;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 27.11.2015.
 */
@WebServlet(name = "DBServlet", urlPatterns = {"/library"})
public class DBServlet extends HttpServlet {
    @Resource(mappedName = "jdbc/library")
    DataSource ds;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("avtor_id")!=null) {
            showBooksByAvtor(request,response);
        } else if (request.getParameter("addavtor")!=null) {
            addavtor(request,response);
        } else if (request.getParameter("delete_avtor_id")!=null) {
            deleteavtor(request,response);
        } else if (request.getParameter("edit_avtor_id")!=null) {
            editavtor(request,response);
        } else {
            showAvtors(request, response);
        }
    }

    private void editavtor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String delete_avtor_id = request.getParameter("delete_avtor_id");
            int id = Integer.parseInt(delete_avtor_id);
            Connection connection = ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM avtor WHERE id = ?");
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Avtor a = new Avtor(rs.getInt(1), rs.getString(2), rs.getString(3));
                request.setAttribute("avtor",a);
                request.getRequestDispatcher("editavtor.jsp").forward(request,response);
            } else {
                response.sendRedirect("library");
            }
        } catch (SQLException e) {

        }
    }

    private void deleteavtor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String delete_avtor_id = request.getParameter("delete_avtor_id");
            int id = Integer.parseInt(delete_avtor_id);
            Connection connection = ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM avtor WHERE id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            response.sendRedirect("library");
        } catch (NumberFormatException e) {
            response.sendRedirect("library");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addavtor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String comment = request.getParameter("comment");
        try {
            Connection connection = ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO avtor (name, comment) VALUES (?,?)");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,comment);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            response.sendRedirect("library");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void showBooksByAvtor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String avtor_id = request.getParameter("avtor_id");
        try {
            int id = Integer.parseInt(avtor_id);
            Connection connection = ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM book WHERE Avtor_id = ?");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            List<Book> books = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book(rs.getInt("id"), rs.getString("nazvanie"), rs.getInt("pages"), rs.getInt("Avtor_id"), rs.getInt("Izdatelstvo_id"));
                books.add(book);
            }
            rs.close();
            preparedStatement.close();
            connection.close();
            request.setAttribute("books",books);
            request.getRequestDispatcher("/booksbyavtor.jsp").forward(request,response);
        } catch (NumberFormatException ex) {
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void showAvtors(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection connection = ds.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM avtor");
            List<Avtor> avtors = new ArrayList<>();
            while (rs.next()) {
                Avtor avtor = new Avtor(rs.getInt("id"), rs.getString("name"), rs.getString("comment"));
                avtors.add(avtor);
            }
            rs.close();
            statement.close();
            connection.close();
            request.setAttribute("avtors", avtors);
            request.getRequestDispatcher("/avtors.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
