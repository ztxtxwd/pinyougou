package com.pinyougou.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.entity.PageResult;
import com.pinyougou.pojo.entity.Result;
import com.pinyougou.sellergoods.service.BrandService;

@RestController()
@RequestMapping("/brand")
public class BrandController {
	@Reference(timeout=10000)
	private BrandService service;
	@RequestMapping("/findAll.do")
	public List<TbBrand> findAll(){
		return service.findAll();
	}
	
	@RequestMapping("/findPage.do")
	public PageResult findPage(int page,int rows){
		return service.findPage(page,rows);
	}
	
	@RequestMapping("/add.do")
	public Result add(@RequestBody TbBrand brand){
		try {
			service.add(brand);
			return new Result(true, "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "添加失败");
		}
		
	}
	
	@RequestMapping("/update.do")
	public Result update(@RequestBody TbBrand brand){
		try {
			service.add(brand);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}
	
	@RequestMapping("/delete.do")
	public Result delete(Long[] ids){
		try {
			service.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
	@RequestMapping("/search.do")
	public PageResult search(@RequestBody TbBrand brand,int page,int rows){
		return service.findPage(brand,page,rows);
	}
}
