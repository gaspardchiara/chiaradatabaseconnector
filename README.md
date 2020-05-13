Chiaradatabase java connector. 

Look, at chiarafile repo for example or javadoc for more details



To compile do

```bash
mvn clean install 
```

An example program  : 
Connect to database and search a file.

```java

DatabaseConfiguration config = new DatabaseConfiguration();

config.setPassword("dontusethispassword");
config.setUser("dontusethisusername");
  byte[] ipbyte = new byte[]{0,0,0,0};
 InetAddress myip = InetAddress.getByAddress(ipbyte);
config.setServerip(myip);
// go do something in the database after the configuration 


DatabaseAction action = new DatabaseAction();

// on this example we want to retrieve data stored in the chiaradatabase for that 

byte[] file = action.getdata(config,fileid);

// consult the javadoc for more detail , but for all the other operations the code style is the same

```
# license 
[GPLv3](https://www.gnu.org/licenses/gpl-3.0.en.html)
