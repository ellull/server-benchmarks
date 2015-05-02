
var http = require('http')

http.createServer(function(req, res) {
	var str = ''
	req.on('data', function(d) {
		str += d
	})
	req.on('end', function() {
		res.writeHeader(200)
		res.end(String(str.length))
	})
}).listen(8080)

