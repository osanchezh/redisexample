import redis

r = redis.Redis(host='192.168.1.70', port=6379, db=0)

pipeline = r.pipeline()

pipeline.hset("user-purchase","customer", "keith")
pipeline.hset("user-purchase", "amount", 100)
pipeline.incr("customer-keith-purchase-count")

results = pipeline.execute()
print(results)