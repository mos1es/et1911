<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
	<h2>测试数组传参</h2>
	<form enctype="application/x-www-form-urlencoded" 
	action="${pageContext.request.contextPath }/complex/array" 
	method="post">
		爱好:
		<input type="checkbox" name="hobby" value="踢球"/>踢球
		<input type="checkbox" name="hobby" value="听音乐"/>听音乐
		<input type="checkbox" name="hobby" value="看书"/>看书
		<br />
		<input type="submit" value="测试数组传参"/>
		
		
	</form>
	<form enctype="application/x-www-form-urlencoded" 
	action="${pageContext.request.contextPath }/complex/list" 
	method="post">
		爱好:
		<input type="checkbox" name="hobbyList" value="踢球"/>踢球
		<input type="checkbox" name="hobbyList" value="听音乐"/>听音乐
		<input type="checkbox" name="hobbyList" value="看书"/>看书
		<br />
		<input type="submit" value="测试list传参"/>
		<hr />
		
	</form>
	<button id ="textMap"type="button">测试Map传参</button>
	
	<button onclick = "jsonToMap()"type="button">测试json转Map传参</button>
	
	<button onclick = "jsonToList()"type="button">测试json转List</button>
	
	<hr />
	<button onclick = "jsonToBean()"type="button">测试json转java Bean</button>
	<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
	<script type="text/javascript">
		const path="${pageContext.request.contextPath}"
		
		$(function(){
			$('#textMap').click(()=>{
				console.log("dsfad");
				$.ajax({
					url:path+'/complex/map',
					type:'post',
					dataType:'text',
					data:"stuMap['id']=1&stuMap['name']=zhangsan",
					success:function(data){
						alert(data);
					}
				})
			})		
		})
		
		function jsonToMap(){
			/*js对象  */
			let obj = {id:1,name:"et1911"};
			$.ajax({
				url:path+'/json/jsonToMap',
				type:'post',
				data:JSON.stringify(obj),//将js对象转换为json字符串
				dataType:'json',
				contentType:'application/json;character=UTF-8',
				success:function(data){
					alert(data.msg);
				}
			})
		}
		
		function jsonToList(){
			let array = [{id:2,name:"et1910",age:21}];
			let user = {id:1,name:"et1911",age:20};
			array.push(user)
			
			$.ajax({
				url:path+'/json/jsonToList',
				type:'post',
				data:JSON.stringify(array),
				dataType:'json',
				contentType: 'application/json;charset=UTF-8',
				success:function(data){
					alert(data.code + "-" +data.msg);
				}
			})
		}
		
		function jsonToBean(){
			let obj = {
					id:1,
					name:"et1911",
					age:20,
					hobbyList:['看书','踢球'],
					stuMap:{id:2,score:200}
			};
			
			$.ajax({
				url:path+ '/json/jsonToBean',
				type:'post',
				data:JSON.stringify(obj),
				dataType:'json',
				contentType:'application/json;charset-UTF-8',
				success:function(data){
					alert(data.code+"-"+data.msg);
				}
				
			})
			
			
		}
	</script>
</body>
</html>














