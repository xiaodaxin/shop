function parseJSON(str){
	
	var p = new Promise(function(resolve,reject){
		var json=JSON.parse(str);
		resolve(json);
	})
	return p
}
