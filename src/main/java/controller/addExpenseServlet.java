package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Expense;

/**
 * Servlet implementation class addExpenseServlet
 */
@WebServlet("/addExpenseServlet")
public class addExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addExpenseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String expense = request.getParameter("expense");
		String amountStr = request.getParameter("amount");
		String frequency = request.getParameter("frequency");
		
		// convert amount to double
		double amount;
		try {
		amount = Double.parseDouble(amountStr);
		}
		catch(NumberFormatException e) {
			amount = 0.0;
		}
		
		Expense ex = new Expense(expense,amount,frequency);
		ExpenseHelper dao = new ExpenseHelper();
		dao.insertExpense(ex);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request,response);
	}

}
