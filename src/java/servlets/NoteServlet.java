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
         Note not = new Note(titleDisplay,contentDisplay);
         request.setAttribute("note", not);
         request.setAttribute("note", not);
         String edt = request.getParameter("edit");
         if(edt == null)
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
         String title = request.getParameter("showTitle");
         String content = request.getParameter("showContent");
         Note no = new Note();
         no.setTitle(title);
         no.setContent(content);
         request.setAttribute("note", no);     
         pw.write(title+ "\n" + content);
         pw.close();
         getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }
}