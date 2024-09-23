package eud.ict.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eud.ict.shape.Grade;




/**
 * Servlet implementation class LottoServelt
 */
@WebServlet("/grade")
public class GradeServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>Hello World</h1>");
		out.print("<body>");
		out.print("<html>");
		out.close();
		
		System.out.println("doGet()..함수 입니다.");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); //Post 방식에서 한글 안깨지게 하는것.
		
		int kor = Integer.valueOf(request.getParameter("kor"));
		int eng = Integer.valueOf(request.getParameter("eng"));
		int math = Integer.valueOf(request.getParameter("math"));
		String name = request.getParameter("name");
		
		Grade grade = new Grade(kor,eng,math,name);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>" + grade.getName() + "</h1>");
		out.print("<h1>당신의 성적은: " + grade.getGrade() + "입니다.</h1>");
		out.print("<h1>평균은 : " + grade.getAvg() + "</h1>");
		out.print("<h1>총점은 : " + (kor + eng + math) + "</h1>");
		out.print("<body>");
		out.print("<html>");
		out.close();

	}

}
