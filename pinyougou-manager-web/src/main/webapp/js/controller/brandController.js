app.controller('brandController',function($scope,$http,brandService){
 	//读取列表数据绑定到表单中
		$scope.findAll=function(){
			$http.get('../brand/findAll.do').success(
				function(response){
					$scope.list=response;
				}
			);
		}
 		$scope.reloadList=function(){
 			$scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
 		}
 		$scope.saveEntity=function(entity){
 			$scope.brand=entity;
 		}
 		$scope.brand={
 				id:0,
 				name:'',
 				firstChar:''
 		}
 		$scope.paginationConf={
 				currentPage:1,
 				totalItems:10,
 				itemsPerPage:10,
 				perPageOptions:[10,20,30,40,50],
 				onChange:function(){
 					$scope.reloadList();
 				}
 		};
 		$scope.findPage=function(page,rows){
 			brandService.findPage(page,rows).success(
 				function(response){
 					$scope.list=response.rows;
 					$scope.paginationConf.totalItems=response.total;
 				}		
 			)
 		}
 		$scope.save=function(id){
 			if($scope.brand.id==0){
 				brandService.add($scope.brand).success(
 		 				function(response){
 		 					if(response.success){
 		 						$scope.reloadList();
 		 					}else{
 		 						alert(response.message);
 		 					}
 		 				}		
 		 			)
 			}else{
 				brandService.update($scope.brand).success(
 		 				function(response){
 		 					if(response.success){
 		 						$scope.reloadList();
 		 					}else{
 		 						alert(response.message);
 		 					}
 		 				}		
 		 			)
 			}
 			
 		}
 		$scope.selectIds=[];
 		$scope.updateSelection=function($event,id){
 			if($event.target.checked){
 				$scope.selectIds.push(id);
 			}else{
 				var idx=$scope.selectIds.indexOf(id);
 				$scope.selectIds.splice(idx,1);
 			}
 		}
 		$scope.dele=function(){
 			brandService.dele($scope.selectIds).success(
 				function(response){
 					if(response.success){
						$scope.reloadList();
					}else{
						alert(response.message);
					}
 				}
 							
 			)
 		}
 		$scope.searchEntity={};
 		$scope.search=function(page,rows){
 			brandService.search(page,rows,$scope.searchEntity).success(
 				function(response){
 					$scope.list=response.rows;
 					$scope.paginationConf.totalItems=response.total;
 				}		
 			)
 		}
	});