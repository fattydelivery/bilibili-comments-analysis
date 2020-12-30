package io.github.fattydelivery.bilibilicommentsanalysis.utils.HBaseToJson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/HeatMapString")
public class HeatMapString extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=utf-8");
        GetHeatMap h = new GetHeatMap();
        String text = h.getKV();
        resp.getWriter().print(text);
    }
}
