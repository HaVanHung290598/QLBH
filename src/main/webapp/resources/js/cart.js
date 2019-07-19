$(document).ready(function(){
	function total_price(){
		var total_price = 0;
		$('.quantity').each(function(){
			total_price += parseInt($(this).val()) * parseInt($(this).data("price"));
		});
		$('.subtotal').val(total_price);
	};
	total_price();
	
	var total_price_cartItem = parseInt($('.subtotal').val()) - (parseInt($('.subtotal').val()) * parseInt($('.discount').val()))/100 + parseInt($('.tax').val());
	$('.total-price-cartItem').val(total_price_cartItem);
	
	$('.quantity').change(function(){
//c1:		var price = $('.price-product', $(this).closest('tr')).val();
//c2:		alert("gia tri la "+ $(this).data("price"));
		var price = $(this).data("price");
		var productId = $('.productId').val();
		var userId = $('.userId').val();
		if($(this).val() < 1){
			alert("Invalid value!!!");
			$(this).val("1");
		}
		var quantity = $(this).val();
		var total = parseInt(price) * parseInt(quantity);
		$('.total-product', $(this).closest('tr')).val(total);
		total_price();
		var total_price_cartItem = parseInt($('.subtotal').val()) - (parseInt($('.subtotal').val()) * parseInt($('.discount').val()))/100 + parseInt($('.tax').val());
		$('.total-price-cartItem').val(total_price_cartItem);
		//===========================================
		//===========================================
		$.ajax({
			url: 'cartItem',
			type: 'GET',
			dataType: 'html',
			data: {
				qtt: quantity,
				productId: productId,
				userId: userId
			}
		});
	});
});