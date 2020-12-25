package io.github.fattydelivery.bilibilicommentsanalysis.utils.hbase2java;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/WordCloudString")
public class WordCloudString extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=utf-8");
        getWordCloud h = new getWordCloud();
        String text = h.getKV();
        resp.getWriter().print(text);
    }
}