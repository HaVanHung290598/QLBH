/**
 * 
 */
$(document).ready(function(){
	$(window).scroll(function(event){
		var pos_body = $('html,body').scrollTop();
		//console.log(pos_body);
		if(pos_body > 300){
			$('.main-menu').addClass('main-menu-scroll');
//			$('.main-menu .menu > li:last > a').addClass('style-text-last');
//			$('.main-menu .menu li:first a').addClass('style-text-first');
		} else {
			$('.main-menu').removeClass('main-menu-scroll');
//			$('.main-menu .menu > li:last > a').removeClass('style-text-last');
//			$('.main-menu .menu li:first a').removeClass('style-text-first');
		}
	});
});