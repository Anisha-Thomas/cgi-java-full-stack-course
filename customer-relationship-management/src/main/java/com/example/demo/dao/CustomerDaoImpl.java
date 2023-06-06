package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;

@Repository
@EnableTransactionManagement
public  class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	private EntityManager entityManager;
	//private SessionFactory sessionFactory;

	

//	public CustomerDaoImpl(SessionFactory sessionFactory) {
//		super();
//		this.sessionFactory = sessionFactory;
//	}

	@Override
	@Transactional
	public List<Customer> findAll() {
		Query query = entityManager.createQuery("from Customer",Customer.class);
		//Session session=sessionFactory.openSession();
		//session.getTransaction().begin();
		//Query query = session.createQuery("from Customer",Customer.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public Customer createCustomer(Customer customer) {
		//Session session=sessionFactory.openSession();
		//session.getTransaction().begin();
		//session.saveOrUpdate(customer);
		entityManager.merge(customer);
		return customer;
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		//Session session=sessionFactory.openSession();
		//Customer customer = session.find(Customer.class, theId);
		Customer customer = entityManager.find(Customer.class, theId);
		return customer;
	}
	@Override
	@Transactional
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		//Session session=sessionFactory.openSession();
		//Customer customer = session.find(Customer.class, id);
		//session.delete(customer);
		Customer customer = entityManager.find(Customer.class, id);
		entityManager.remove(customer);
	}
//	@Override
//	public List<Customer> findAllById(Iterable<Integer> ids) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Customer> List<S> saveAll(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void flush() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public <S extends Customer> S saveAndFlush(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Customer> List<S> saveAllAndFlush(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void deleteAllInBatch(Iterable<Customer> entities) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void deleteAllInBatch() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public Customer getOne(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Customer getById(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Customer getReferenceById(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Customer> List<S> findAll(Example<S> example) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Customer> List<S> findAll(Example<S> example, Sort sort) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Page<Customer> findAll(Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Customer> S save(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Optional<Customer> findById(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean existsById(Integer id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public long count() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//

	@Override
	public List<Customer> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Customer> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Customer> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getReferenceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Customer> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Customer> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Customer entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Customer> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Customer> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Customer> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Customer, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
}
