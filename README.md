#WarDBC
**A simple World of Warcraft DBC toolkit for Java**

####Primary API
```java
DBC.header(byte[]) -> DBC.Header
```
Extract the DBC header from the DBC data (already loaded as bytes).  [The header contains](https://github.com/adraffy/wardbc/blob/master/src/com/antistupid/wardbc/DBC.java#L47) format, row, column, and other information.

```java
DBC.read(byte[], DBC.Header, Decoder<T>, Consumer<T>)
```
Extract the DBC content from the DBC data (already loaded as bytes).  You may provide a previously parsed header or null.  The decoder is given a ByteBuffer and returns a type which represents a row.  The decoded row is then passed to the consumer.

Parsing the header before calling this function is useful for things like: allocating a sufficient storage capacity or verifying the decoder has the correct number of columns.

###_But raffy, I'm so lazy!_

####Lazy API
```java
LazyDBC lazy = new LazyDBC(Paths.get("DBFilesClient"));
```
Create a LazyDBC instance with a directory containing DBC files.

The LazyDBC loader uses Java reflection to turn mutable struct-like objects into DBC rows.  Simply subclass `LazyRow<K>`, statically define the associated file name, define your columns, and define the primary key `K`.  You can use `LazyRowId` if the primary key is an integer and is the first column.


Here is an example:
```java
package wardbc.lazy.rows;

import wardbc.lazy.LazyRowId;

public class ExampleData extends LazyRowId {

    static public final String FILE = "Example.dbc";
    
    // public int id; // not required: defined through LazyRowId
    public String someString;
    public int someInt;
    public float[] someFloats = new float[3];
    public byte someByte;
    public boolean someBool;
    
}
```
Assuming there is a `Example.dbc` file in the directory associated with your LazyDBC instance, `ExampleData.class` is ready to be used.

[A full list of supported files can be found here](https://github.com/adraffy/wardbc/tree/master/src/com/antistupid/wardbc/lazy/rows).


####Read via Lazy Class
```java
// dump to stdout using toString()
lazy.dump(ExampleData.class);

// load to list
ArrayList<ExampleData> list = lazy.list(ExampleData.class);

// load to array
ExampleData[] array = lazy.array(ExampleData.class);

// load to map
TreeMap<Integer,ExampleData> map = lazy.map(ExampleData.class);
```

####Inspection via Lazy Class
```java
// load some data
TreeMap<Integer,ExampleData> map = lazy.map(ExampleData.class);

// dump to stdout with multi-line formating
map.get(12345).dump();
/* eg.       id = 12345
     someString = "u wot m8"
        someInt = 1337
     someFloats = [0.3, 0.4, 0.7] ... */

// dump to string with inline formatting
map.get(67890).toString();
// eg. id(67890) someString(u wot m8) someInt(1337) someFloats([0.3, 0.4, 0.7]) ...

```

####Reflection via Lazy Class
```java
// get number of columns found through reflection
LazyDBC.getFieldCount(ExampleData.class); 
// eg. 8

// get file name
LazyDBC.getFileName(ExampleData.class); 
// eg. "ExampleData.dbc"

// get path of file (note: must be called on a lazy instance)
lazy.getFile(ExampleData.class); 
// eg. "~/DBClientFiles/ExampleData.dbc"

// get a reflection decoder (for use with primary API)
LazyDBC.getDecoder(ExampleData.class); 

// convert to string
ExampleData obj = ...
LazyDBC.toString(obj, true); // inline string
// related: obj.toString()
LazyDBC.toString(obj, false); // multi-line string
// related: obj.dump()
```
