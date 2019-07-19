/**
 * 
 */
$(document).ready(function(){
	$('.repairStatus').click(function(){
		$('.status', $(this).closest('tr')).removeAttr('disabled');
	});
	$('.status').change(function(){
		alert("vao r!.....");
		var invoiceId = $('.invoiceId',$(this).closest('tr')).text();
		var status = $(this).val();
		$.ajax({
			url: 'updateInvoice',
			type: 'POST',
			dataType: 'html',
			data: {
				id : invoiceId,
				invoiceStatus : status
			}
		});
	});
});