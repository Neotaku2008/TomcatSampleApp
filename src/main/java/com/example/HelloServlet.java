package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;
//import java.lang.management.RuntimeMXBean;
import java.io.File;

public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Sample Tomcat App</title>");
        out.println("<style>");
        out.println("body {");
        out.println("    font-family: Arial, sans-serif;");
        out.println("    background-color: #f0f0f0;");
        out.println("    text-align: center;");
        out.println("}");
        out.println("h1 {");
        out.println("    color: #333333;");
        out.println("}");
        out.println(".chart {");
        out.println("    width: 400px;");
        out.println("    height: 200px;");
        out.println("    margin: 20px auto;");
        out.println("    background-color: #f5f5f5;");
        out.println("    border: 1px solid #ccc;");
        out.println("    padding: 10px;");
        out.println("    box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);");
        out.println("}");
        out.println(".info {");
        out.println("    background-color: #fff;");
        out.println("    padding: 10px;");
        out.println("    border-radius: 5px;");
        out.println("    box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello from HelloServlet!</h1>");
        out.println("<div class='chart'></div>");

        Date date = new Date();
        out.println("<div class='info'>");
        out.println("<p>Fecha y hora actual: " + date.toString() + "</p>");

        String serverName = request.getServerName();
        out.println("<p>Nombre del servidor: " + serverName + "</p>");

        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        long usedHeapMemory = heapMemoryUsage.getUsed() / (1024 * 1024); // Convertir a MB
        long maxHeapMemory = heapMemoryUsage.getMax() / (1024 * 1024); // Convertir a MB
        out.println("<p>Memoria RAM utilizada: " + usedHeapMemory + " MB</p>");
        out.println("<p>Memoria RAM máxima: " + maxHeapMemory + " MB</p>");

        File file = new File("/");
        long totalSpace = file.getTotalSpace() / (1024 * 1024 * 1024); // Convertir a GB
        long freeSpace = file.getFreeSpace() / (1024 * 1024 * 1024); // Convertir a GB
        out.println("<p>Espacio en disco total: " + totalSpace + " GB</p>");
        out.println("<p>Espacio en disco libre: " + freeSpace + " GB</p>");

        // Obtener el porcentaje de uso del procesador
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        double cpuUsage = osBean.getSystemLoadAverage();
        out.println("<p>Porcentaje de uso del procesador: " + cpuUsage + "</p>");

        out.println("</div>");

        out.println("<p>Welcome to our sample Tomcat application.</p>");
        out.println("</body>");
        out.println("</html>");
    }
}