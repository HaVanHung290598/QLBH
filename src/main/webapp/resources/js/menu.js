/**
 * 
 */
$(document).ready(function(){
	$('.menu li:has(ul)').hover(function(){
		$(this).find('ul').slideDown();
	},function(){
		$(this).find('ul').slideUp();
	});
});