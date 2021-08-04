/**
 * 
 */
var replyService = (function(){
	function add(contextPath, data, callback, callback2){
		$.ajax({
			type:'post',
			url : contextPath + '/reply/add',
			data: JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			success: function(res){
				if(callback){
					callback(res,'등록');
					list(contextPath,{page:1, rp_bd_num : data.rp_bd_num},callback2);
				}
			}
		})
	}
	function list(contextPath, data, callback){
		$.ajax({
			type : 'get',
			url  : contextPath + '/reply/list/' + data.page + '/'+ data.rp_bd_num,
			dataType : "json",
			success  : function(res){
				if(callback)
					callback(res);
			}
		})
	}
	function mod(contextPath, data, callback, listCallback){
		$.ajax({
			type : 'post',
			url  : contextPath + '/reply/mod',
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			success : function(res){
				if(callback){
					callback(res,'수정');
					replyService.list(contextPath, {page : data.page, rp_bd_num: data.rp_bd_num}, listCallback);
				}
			}
		})
	}
	function del(contextPath, data, callback, listCallback){
		$.ajax({
			type : 'post',
			url  : contextPath + '/reply/del',
			data : data,
			success : function(res){
				if(callback){
					callback(res, '삭제');
					list(contextPath, {page : 1, rp_bd_num: data.rp_bd_num}, listCallback);	
				}
				
			}
		})
	}
	return {
		name : '댓글 서비스',
		add  : add,
		list : list,
		mod  : mod,
		del  : del
	};
})();