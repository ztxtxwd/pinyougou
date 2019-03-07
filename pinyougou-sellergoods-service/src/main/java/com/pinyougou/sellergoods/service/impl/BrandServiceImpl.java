package com.pinyougou.sellergoods.service.impl;

import java.util.List;













import javax.naming.ldap.PagedResultsControl;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.container.page.PageHandler;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;
import com.pinyougou.pojo.entity.PageResult;
import com.pinyougou.pojo.entity.Result;
import com.pinyougou.sellergoods.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{
	@Autowired
	private TbBrandMapper mapper;
	
	@Override
	public List<TbBrand> findAll() {
		// TODO Auto-generated method stub
		return mapper.selectByExample(null);
	}
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		Page<TbBrand> page= (Page<TbBrand>) mapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}
	@Override
	public void add(TbBrand brand) {
		// TODO Auto-generated method stub
		if (brand.getId()==0) {
			mapper.insert(brand);
		}else{
			mapper.updateByPrimaryKey(brand);
		}
		
	}
	@Override
	public void update(TbBrand brand) {
		// TODO Auto-generated method stub
		mapper.updateByPrimaryKey(brand);
		
	}
	@Override
	public void delete(Long[] ids) {
		// TODO Auto-generated method stub
		for (Long id : ids) {
			mapper.deleteByPrimaryKey(id);
		}
	}
	@Override
	public PageResult findPage(TbBrand brand,int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		TbBrandExample example=new TbBrandExample();
		Criteria criteria=example.createCriteria();
		
		if (brand!=null) {
			if (brand.getName()!=null&&brand.getName()!=null) {
				criteria.andNameLike("%"+brand.getName()+"%");
			}
			if (brand.getFirstChar()!=null&&brand.getFirstChar().length()>0){
				criteria.andFirstCharEqualTo(brand.getFirstChar());
			}
		}
		Page<TbBrand> page=(Page<TbBrand>) mapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
