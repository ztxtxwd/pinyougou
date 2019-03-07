app.service('brandService',function($http){
    	this.search=function(page,rows,searchEntity){
    		return $http.post("../brand/search.do?page="+page+"&rows="+rows,searchEntity);
    	}
    	this.dele=function(selectIds){
    		return $http.get("../brand/delete.do?ids="+selectIds);
    	}
    	this.add=function(entity){
    		return $http.post('../brand/add.do',entity);
    	}
    	this.update=function(entity){
    		return $http.post('../brand/update.do',entity);
    	}
    	this.findPage=function(page,rows){
    		return $http.get('../brand/findPage.do?page='+page+'&rows='+rows);
    	}
    });