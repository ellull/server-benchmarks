# server-benchmarks
Simple benchmarks, initially Node.js vs. Java (plus Python)

Just build (if needed :) and run one of the servers and then try something like this and note how many requests per second can it serve...

```
ab -p POST_DATA.txt -n 10000 -c 10 http://localhost:8080/
```
