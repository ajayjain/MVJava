(function(window, document) {
	document.createElement(p);
	p.innerHTML = "hi lee";
	for (var i = 0; i < 10; i++) {
		document.appendChild(p);
	}
	
})(this, document);
