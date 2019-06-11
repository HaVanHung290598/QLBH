$(document).ready(function(){
	function total_price(){
		var total_price = 0;
		$('.quantity').each(function(){
			total_price += parseInt($(this).val()) * parseInt($(this).data("price"));
		});
		$('.subtotal').val(total_price);
	};
	total_price();
	
	var total_price_cartItem = parseInt($('.subtotal').val()) + parseInt($('.delivery').val()) + parseInt($('.discount').val());
	$('.total-price-cartItem').val(total_price_cartItem);
	
	$('.quantity').change(function(){
//c1:		var price = $('.price-product', $(this).closest('tr')).val();
//c2:		alert("gia tri la "+ $(this).data("price"));
		var price = $(this).data("price");
		var quantity = $(this).val();
		var total = parseInt(price) * parseInt(quantity);
		$('.total-product', $(this).closest('tr')).val(total);
		total_price();
		var total_price_cartItem = parseInt($('.subtotal').val()) + parseInt($('.delivery').val()) + parseInt($('.discount').val());
		$('.total-price-cartItem').val(total_price_cartItem);
	});
});