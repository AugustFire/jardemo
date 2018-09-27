## JWT

## 消息构成

- header
- payload
- signature

由三部分生成token

### header

承载两部分信心

- 申明类型 jwt
- 申明加密算法 通常 hmac sha256

```groovy
del map = new HashMap()
map.put("alg","HS256")
map.put("typ","JWT")
```



### payload

- iss: jwt签发者
- sub: jwt所面向的用户
- aud: 接收jwt的一方
- exp: jwt的过期时间，这个过期时间必须要大于签发时间
- nbf: 定义在什么时间之前，该jwt都是不可用的.
- iat: jwt的签发时间

++ 自定义数据

JJWT

[JJWT参考](https://blog.csdn.net/achenyuan/article/details/80829401#jwt%E5%85%A8%E9%9D%A2%E8%A7%A3%E8%AF%BB)

