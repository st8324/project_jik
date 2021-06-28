var id;
$(function(){
	// 오른쪽 두번째 컨텐츠 롤링 기능
	id = rollingLeft('.right2 .view-box .contents-box', 'li', 800, 1500);
	$('.right2').hover(function(){
		clearInterval(id);
	},function(){
		id = rollingLeft('.right2 .view-box .contents-box', 'li', 800, 1500);
	})
	// 오른쪽 두번째 컨텐츠 다음 버튼
	$('.right2 .btn-box .next-btn').click(function(){
		if(!$('.right2 .contents-box li').first().is(':animated')){
			var width = $('.right2 .contents-box li').first().width();
			$('.right2 .contents-box li').first()
				.animate({'margin-left': -width+'px'},800,function(){
					$(this).detach().appendTo('.right2  .contents-box').removeAttr('style');
				})
		}
	})
	// 오른쪽 두번째 컨텐츠 이전 버튼
	$('.right2 .btn-box .prev-btn').click(function(){
		if(!$('.right2 .contents-box li').first().is(':animated')){
			var width = $('.right2 .contents-box li').first().width();
			$('.right2 .contents-box li').last().detach().prependTo('.right2  .contents-box')
				.css('margin-left',-width+'px').animate({'margin-left':0}, 800);
		}
	})
})