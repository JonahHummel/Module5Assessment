package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Expense;

public class ExpenseHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ExpenseTracker");

	public void insertExpense(Expense ex) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ex);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Expense> showExpenses(){
		EntityManager em = emfactory.createEntityManager();
		List<Expense> allExpenses = em.createQuery("SELECT i FROM Expense i").getResultList();
		return allExpenses;
	}
	
	public void deleteExpense(Expense toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Expense> typedQuery = em.createQuery("select ex from Expense ex where ex.item = :selectedItem and ex.amount = :selectedAmount and ex.frequency = :selectedFrequency", Expense.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedItem", toDelete.getItem());
		typedQuery.setParameter("selectedAmount", toDelete.getAmount());
		typedQuery.setParameter("selectedFrequency", toDelete.getFrequency());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Expense result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}
	
	public Expense searchForExpenseById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Expense found = em.find(Expense.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateExpense(Expense toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
