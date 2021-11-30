package servlet;

public class ContentGenerator {
    public String content() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <title>Adding Form</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"addProduct\" method=\"POST\">\n" +
                "  Product Name: <input name=\"name\"/>\n" +
                "  <br><br>\n" +
                "  Quantity: <input name=\"quantity\" />\n" +
                "  <br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\" />\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>";
    }
}
