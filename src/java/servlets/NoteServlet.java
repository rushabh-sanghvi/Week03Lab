/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author 794466
 */
public class NoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt"); 
        // to read file
         BufferedReader br = new BufferedReader(new FileReader(new File(path)));
         String titleDisplay = br.readLine();
         String contentDisplay = br.readLine();
        Note n = new Note(titleDisplay,contentDisplay);
         request.setAttribute("note", n);
         request.setAttribute("note", n);
         String e = request.getParameter("edit");
         if(e == null)
         {
             getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
         }
         else
         {
             getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
         }
         br.close();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
         String path = getServletContext().getRealPath("/WEB-INF/note.txt");
         // to write to a file
         PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
         String t = request.getParameter("showTitle");
         String c = request.getParameter("showContent");
         Note n = new Note();
         n.setTitle(t);
         n.setContent(c);
         request.setAttribute("note", n);     
         pw.write(t+ "\n" + c);
         pw.close();
         getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }
}