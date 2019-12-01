<p align="center"><img src="logo.png" /></p>

<h1 align="center"> Redis Boilerplate - Readme.md HTML Template </h1>

<p align="center"> Intro - Proof of concept Spring Cache Redis JSR-107 </p>

<hr/>

<p> Validate in detail every concepts of the spring cache with redis integration. </p>

<h3> Download & Installation </h3>

```shell
$ ./gradlew bootRun
```

<h3> Inside Technology </h3>

If the project runs set randomUUID and save in Redis DataStore, the spring cache 
uses the next key ```listView::SimpleKey []```, that one is assigned on decorators ```@Cacheable("listView")```
SimpleKey Word is generic and array is because the return of the method is java.util.List.

In letters word,

```java
@EnableCaching
public class RedisBoilerplateApplication {
    public static void main(String... args){...}
}

public class MockRepository {

    @Cacheable("listView")
    public List<String> findAll() {
        log.debug("findAll method executed once");
        return this.listView;
    }
}
```

```shell script

redis 127.0.0.1:6379> keys *
(empty list or set)
redis 127.0.0.1:6379> keys *
1) "listView::SimpleKey []"
redis 127.0.0.1:6379> GET listView::SimpleKey []
(error) ERR wrong number of arguments for 'get' command
redis 127.0.0.1:6379> GET "listView::SimpleKey []"
"\xac\xed\x00\x05sr\x00\x13java.util.ArrayListx\x81\xd2\x1d\x99\xc7a\x9d\x03\x00\x01I\x00\x04sizexp\x00\x00\x00\nw\x04\x00\x00\x00\nt\x00$d1202204-0a6f-404e-8ddb-263d06f44009t\x00$da9db1e6-0a36-4f8c-98d6-7448a6a93b9bt\x00$fa196bc2-c7fa-490e-a21a-af74f8566773t\x00$008c58e6-cd4e-46a7-893e-c9f32e690d5et\x00$2788aa8c-d275-4dc9-936e-66e8296191a8t\x00$0cc6222a-075c-41c5-b950-43c70f5e6f80t\x00$7534c0f4-d55b-4630-b4e1-309462208281t\x00$c79a367a-07bc-4f71-969b-16111efca285t\x00$b8864c26-4e03-4891-8bec-758a1b3fb713t\x00$aab1cc6a-45b4-42d1-b2ec-bd3df8aef707x"
redis 127.0.0.1:6379>

```

**Into the data spring cache adds a prefix to track it \xac\xed\x00\x05sr\x00\x13java.util.ArrayListx\x81\xd2\x1d\x99\xc7a\x9d\x03\x00\x01I\x00\x04sizexp\x00\x00\x00\nw\x04\x00\x00\x00\nt\x00$<> where <> is the request value**

<h3>Contributing</h3>
Keep it simple. Keep it minimal. Don't put every single feature just because you can.

<h3>Authors or Acknowledgments</h3>
<ul>
  <li>Stephano Apiolaza</li>
</ul>

<h3>License</h3>

This project is licensed under the MIT License
