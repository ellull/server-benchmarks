
var http = require('http')
var cluster = require('cluster')

if (cluster.isMaster) {
	var numCPUs = 0
	var firstArg = process.argv[2]
	if (isNaN(firstArg)) {
		numCPUs = require('os').cpus().length
	} else {
		numCPUs = Number(firstArg)
	}
	console.log('Using numCPUs = ' + numCPUs)
	for (var i = 0; i < numCPUs; i++) {
		cluster.fork()
	}
} else {
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
}

