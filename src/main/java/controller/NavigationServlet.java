package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Expense;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("doThisToItem");
		String path = "/viewExpenseReportServlet";
		
		ExpenseHelper dao = new ExpenseHelper();
		
		if (act.equals("delete")) {
			
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Expense expenseToDelete = dao.searchForExpenseById(tempId);
			dao.deleteExpense(expenseToDelete);
			
		} else if (act.equals("edit")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Expense itemToEdit = dao.searchForExpenseById(tempId);
			request.setAttribute("itemToEdit", itemToEdit);
			path = "/edit-expense.jsp";
		} else if (act.equals("add")) {
		path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
