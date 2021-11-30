package servlet;

import javax.servlet.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AddingFormServlet implements Servlet {

    private final ContentGenerator contentGenerator;
    private ServletConfig servletConfig;

    public AddingFormServlet(ContentGenerator contentGenerator) {
        this.contentGenerator = contentGenerator;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try (ServletOutputStream outputStream = res.getOutputStream()) {
            outputStream.write(contentGenerator.content().getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
