package dao;

import java.util.List;

import beans.Province;

public interface ProvinceDao {
	public Province getById(int id);
	
	public List<Province> getAll();
	
	public void save(Province province);
}
