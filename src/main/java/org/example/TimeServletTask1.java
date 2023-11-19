package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(value = "/time")
public class TimeServletTask1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        LocalDateTime currentTime = LocalDateTime.now();
        // Отримати системний часовий пояс
        ZoneId currentZone = ZoneId.systemDefault();
        // Перетворити локальний час в UTC
        ZonedDateTime currentUTC = currentTime.atZone(currentZone).withZoneSameInstant(ZoneId.of("UTC"));
        // Сформувати формат для виведення
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        writer.write(currentUTC.format(formatter));
        writer.flush();
        writer.close();
    }
}
