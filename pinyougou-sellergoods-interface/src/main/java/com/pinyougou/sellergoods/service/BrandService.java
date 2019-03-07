package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;
import entity.Result;


public interface BrandService {
	public List<TbBrand> findAll();

	public PageResult findPage(int page, int rows);

	public void add(TbBrand brand); 
	
	public void update(TbBrand brand);

	public void delete(Long[] ids);

	public PageResult findPage(TbBrand brand, int page, int pageSize);
}

