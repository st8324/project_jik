/**
 * 
 */
var replyService = (function(){
	function add(contextPath, data, callback){
		$.ajax({
			type:'post',
			url : contextPath + '/reply/add',
			data: JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			success: function(res){
				if(callback)
					callback(res);
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
	return {
		name : '댓글 서비스',
		add  : add,
		list : list
	};
})();