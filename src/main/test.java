package main;

import beans.Province;
import service.ProvinceService;
import service.ProvinceServiceImpl;
import util.ServiceFactory;

public class test {

	public static void main(String[] args) {
		ProvinceService ps = (ProvinceService) ServiceFactory.getService(new ProvinceServiceImpl());
		
		Province province = ps.getById(1);
		System.out.println(province);
	}

}
