/**
 * 
 */
$(document).ready(function(){
	$('#home').click(function(){
		alert("Hello Jquery");
	});
	
	function startSlider(){
		interval = setInterval(function(){
			$('#show-trending-content').animate({'margin-left':'-=380'},1000,function(){
				$('.trending-content:first').appendTo('#show-trending-content');
				$('#show-trending-content').css('margin-left',0);
			});
		},3000);
	}
	function pauseSlider(){
		clearInterval(interval);
	}
	$('#show-trending-content').on('mouseenter',pauseSlider).on('mouseleave',startSlider);
	startSlider();
	
//	function startSliderManager(){
//		interval2 = setInterval(function(){
//			$('.manager > div > div').animate({'margin-left':'-=798'},1000,function(){
//				$('.manager:first').appendTo('.manager > div > div');
//				$('.manager > div > div').css('margin-left',0);
//			});
//		},3000);
//	}
//	function pauseSlierManager(){
//		clearInterval(interval2);
//	};
//	$('.manager > div > div').on('mouseenter',pauseSlider).on('mouseLeave',startSlider);
//	startSliderManager();
});
