package net.codeJava.sup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService
{
	@Autowired
	private SupplierRepository repo;
	
	public List<Supplier> listAll()
	{
		return repo.findAll();
	}
	
	public void save(Supplier supplier)
	{
		repo.save(supplier);
	}
	
	public Supplier get(long id)
	{
		return repo.findById(id).get();
		
	}
	
	public void delete(Long id)
	{
		repo.deleteById(id);
	}
}
