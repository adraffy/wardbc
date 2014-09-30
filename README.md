#WarDBC
A World of Warcraft DBC toolkit for Java

###Setup
```java
LazyDBC lazy = new LazyDBC(Paths.get("DBFilesClient"));
```

###Read
```java

lazy.dump(ItemSparse.class);
lazy.list(RandPropPoints.class).forEach(...);
```

###Inspect
```java
lazy.map(ItemSparse.class).get(102248).dump();
lazy.map(SpellEffect.class).get(5221).dump();
```

###Supported Files
https://github.com/adraffy/wardbc/tree/master/src/wardbc/lazy/rows
