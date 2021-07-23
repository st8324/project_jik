/**
 * 
 */
var replyService = (function(){
	
	function insert(contextPath, data){
		$.ajax({
			type : 'post',
			url  : contextPath+'/reply/ins',
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				if(result == 'OK'){
					list(contextPath, data['rp_bd_num'], 1, data['re_me_id']);
					$('.reply-input').val('');
					alert('댓글이 등록되었습니다.');
				}
			}
		})
	}
	function list(contextPath, rp_bd_num, page, id){
		$.ajax({
			type : 'get',
			url : contextPath + '/reply/list/' + rp_bd_num + '/' + page,
			dataType : 'json',
			success : function(result){
				var str = '<hr style="background:red;"/>';
				for(reply of result['replyList']){
					str += 
						'<div>'+
							'<label>'+reply['rp_me_id']+'</label>'+
							'<div class="form-control">'+reply['rp_content']+'</div>'+
						'</div>';
					if(reply['rp_me_id'] == id){
						str +=
							'<div>' + 
								'<button type="button" class="btn btn-outline-danger mod-btn">수정</button>' +
							'</div>'; 
					}
				}
				str += '<hr style="background:red;"/>';
				$('.reply-list').html(str);

				var pmStr = '';
				var pm = result['pm'];
				if(pm.prev)
					pmStr += '<li class="page-item" data="'+(pm.startPage-1)+'"><a class="page-link" href="javascript:void(0);">이전</a></li>';
				
				for(i = pm.startPage; i<=pm.endPage; i++){
					if(pm.criteria.page == i)
						pmStr += '<li class="page-item active" data="'+ i +'"><a class="page-link" href="javascript:void(0);">'+i+'</a></li>';
					else
						pmStr += '<li class="page-item" data="'+ i +'"><a class="page-link" href="javascript:void(0);">'+i+'</a></li>';	
				}
				if(pm.next)					
					pmStr += '<li class="page-item"  data="'+(pm.endPage+1)+'"><a class="page-link" href="javascript:void(0);">다음</a></li>';				
				
				$('.pagination').html(pmStr);
			}
		})
	}
	return { 
		name : '서비스',
		insert : insert,
		list : list
	}
})();

