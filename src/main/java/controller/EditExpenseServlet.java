package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Expense;

/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editExpenseServlet")
public class EditExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditExpenseServlet() {
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
		ExpenseHelper dao = new ExpenseHelper();
		
		String item = request.getParameter("item");
		String amountStr = request.getParameter("amount");
		String frequency = request.getParameter("frequency");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Expense expenseToUpdate = dao.searchForExpenseById(tempId);
		
		expenseToUpdate.setItem(item);
		
		// convert amount to double
				double amount;
				try {
				amount = Double.parseDouble(amountStr);
				}
				catch(NumberFormatException e) {
					amount = 0.0;
				}
		
		expenseToUpdate.setAmount(amount);
		expenseToUpdate.setFrequency(frequency);
		dao.updateExpense(expenseToUpdate);
		getServletContext().getRequestDispatcher("/viewExpenseReportServlet").forward(request, response);
	}

}
