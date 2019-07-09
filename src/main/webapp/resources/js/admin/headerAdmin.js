/**
 * 
 */
$(document).ready(function(){
	$('header .search a').click(function(){
		$('header .app-search').slideDown();
		$('header .app-search').addClass('display');
	});
	$('header .app-search button').click(function(){
		$('header .app-search').slideUp();
		$('header .app-search').removeClass('display');
	});
	$('header .logo .show-search').click(function(){
		$('header .header-right').slideToggle();
		$('header .header-right').addClass('displayBlock');
	});	
});