/**
 * 
 */
function cong(){
	var numberProduct = document.getElementById("number-product").value;
	document.getElementById("number-product").value = parseInt(numberProduct) + 1;
}
function tru(){
	var numberProduct = parseInt(document.getElementById("number-product").value);
	if(numberProduct > 1){
		document.getElementById("number-product").value = numberProduct - 1;
	}
}
