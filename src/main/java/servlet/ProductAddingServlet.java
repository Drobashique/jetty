package servlet;

import dbCon.Connector;
import entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductAddingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        ProductEntity product = new ProductEntity();
        product.setName(req.getParameter("name"));
        product.setQuantity(Integer.parseInt(req.getParameter("quantity")));

        Connection connection = Connector.connect();
        try{
            PreparedStatement statement = connection.prepareStatement("insert into \"products\"(name,quantity) values (?,?)");
            statement.setString(1,product.getName());
            statement.setInt(2, product.getQuantity());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/").forward(req,resp);
    }
}
