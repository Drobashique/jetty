package servlet;
import dbCon.Connector;
import entity.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        List<ProductEntity> list = new ArrayList<>();

        Connection connection = Connector.connect();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from \"products\"");
            while (rs.next()){
                list.add(new ProductEntity(rs.getInt(1),rs.getString(2),rs.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        writer.write("<html><head></head><body>\n");
        writer.write("Продукты:\n\n");
        writer.write("<table><tr><th>Id</th><th>Товар</th><th>Наличие</th></tr>\n");

        for (ProductEntity product : list) {
            writer.write("<tr><td>"+product.getId()+"</td><td>" + product.getName() + "</td><td>" + product.getQuantity()+ "</td></tr>\n");
        }

        writer.write("</body></html>");
    }
}