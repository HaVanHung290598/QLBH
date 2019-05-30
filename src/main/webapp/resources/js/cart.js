$(document).ready(function(){
	$('.quantity').change(function(){
//c1:		var price = $('.price-product', $(this).closest('tr')).val();
//c2:		alert("gia tri la "+ $(this).data("price"));
		var price = $(this).data("price");
		var quantity = $(this).val();
		var total = parseInt(price) * parseInt(quantity);
		$('.total-product', $(this).closest('tr')).val(total);
	});
});