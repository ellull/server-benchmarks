
import tornado.httpserver
import tornado.ioloop
import tornado.web

class MainHandler(tornado.web.RequestHandler):

	def post(self):
		self.write(str(len(self.request.body)))

app = tornado.web.Application(handlers=[
	(r"/", MainHandler),
])

if __name__ == "__main__":
	http_server = tornado.httpserver.HTTPServer(app)
	http_server.listen(8080)
	tornado.ioloop.IOLoop.instance().start()

