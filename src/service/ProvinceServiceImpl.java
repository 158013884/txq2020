package service;

import java.util.List;

import beans.Province;
import dao.ProvinceDao;
import util.sqlSessionUtil;

public class ProvinceServiceImpl implements ProvinceService{
	private ProvinceDao provinceDao = sqlSessionUtil.getSession().getMapper(ProvinceDao.class);
	
	@Override
	public Province getById(int id) {
		Province province = provinceDao.getById(id);
		return province;
	}

	@Override
	public List<Province> getAll() {
		List<Province> provinces = provinceDao.getAll();
		return provinces;
	}

	@Override
	public void save(Province province) {
		provinceDao.save(province);
	}

}
