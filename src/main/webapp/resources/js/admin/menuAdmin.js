/**
 * 
 */
$(document).ready(function(){
	$('.show-menu').click(function(){
		$('.menu').slideToggle();
	});
	$(window).resize(function(){
		var width = $(window).width();
		
		if(width >= 768 && width <= 1170) {
			console.log(width);
			$('.menu').css('max-width', 70);
			$('.content').removeClass('col-md-10');
			$('.menu').removeClass('col-md-2')
			$('.content').css('max-width', width-70);

			$('.menu').hover(function(){
				$('.menu').css('max-width','');
				$('.content').css('max-width','');
				$('.menu').addClass('col-md-3');
				$('.content').addClass('col-md-9');
			},function(){
				$('.menu').removeClass('col-md-3');
				$('.content').removeClass('col-md-9');
				$('.content').css('max-width', width-70);
			});
		} else {
			$('.menu').off( "mouseenter mouseleave" );
			$('.menu').addClass('col-md-2');
			$('.content').addClass('col-md-10');
			$('.menu').css('max-width','');
			$('.content').css('max-width','');
		}
	});
});