import redis;
import uuid;

r = redis.Redis(host="192.168.1.70", port=6379, db=0);

def create_saiyan(name:str, powerlevel:int):
    saiyan_id=uuid.uuid4();
    p=r.pipeline();

    #p.watch(f"saiyan:nameidx:{name}");
    p.multi();
    sai={"name": name, "powerlevel": powerlevel};

    p.hset(f"saiyan:{saiyan_id}", "name", name, "powerlevel", powerlevel );

    #res= p.set(f"saiyan:nameidx:{name}",saiyan_id, nx=True );
    #if res is None:
    #    p.discard()
    #    raise Exception("user already exists");

    #p.zadd("saiyan:powerlevel",{saiyan_id:powerlevel});
    p.execute();

if __name__ == "__main__":
    create_saiyan("u2",2);