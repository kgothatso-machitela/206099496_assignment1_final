package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SessionFactory;

import entities.EmployeeEntity;

/**
 * Session Bean implementation class EmployeeEJB
 *
 */
@Stateless
@LocalBean
public class EmployeeEJB<Employee> {
	SessionFactory sessionFactory;
	@PersistenceContext
	private EntityManager em;

	public EmployeeEJB() {
		// TODO Auto-generated constructor stub
	}

	public void addNew(EmployeeEntity employeeEntity) {
		System.out.println("============================");
		System.out.println(employeeEntity.getName());
		em.persist(employeeEntity);
		System.out.println("============================");
	}

	@SuppressWarnings("rawtypes")
	public List findEmployees() {
	// TODO Auto-generated method stub
		System.out.println("======Reading Employees=======");

		Query queryObj = em.createQuery("SELECT e FROM employee_tbl e");
		List employeeList =  queryObj.getResultList();
		System.out.println("=======End of Reading Employees=========");
		if (employeeList != null && employeeList.size() > 0) {
			return employeeList;
		} else {
			return null;
		}

	}
}
