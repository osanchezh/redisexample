import redis;

r = redis.Redis(host="192.168.1.70", port=6379, db=0);

def create_user(email:str):
    user_id="myuuid";

    res= r.get(f"user_email:{email}");
    if res is not None:
        raise Exception("user already exists");

    r.hset(f"user:{user_id}", "email", email);

    res= r.set(f"user_email:{email}",user_id, nx=True);
    if res is None:
        raise Exception("User already exists");

if __name__ == "__main__":
    create_user("a1@mail.com");
