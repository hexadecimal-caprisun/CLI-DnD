# Update Log :)

## 11/30/23 -  Diverse enemies

I added the ability to have different enemies. I haven't added the ability for them to do different damage or anything since I only worked on it for like 10 minutes tonight, but at least now you don't fight the same bandit every time :3 (before it would only spawn a bandit in the little playtest demo debug thingy).
```java
String[] possible = {"Bandit","Bear","Ape"};

public void setEnemy(){
    name = possible[r.nextInt(possible.length)];
}
```
This is the code that does it! Just call it after creating a new enemy and it sets it to a random enemy! wow ! so cool !!

### Before today

Honestly I don't know exactly what I did before today :D ... I'll break it down and comment everything out later when I get around to it (when I decide the whole systems sucks and is clunky (because it is) and tear the whole thing down to remake it (I'll probably do that in a few days anyway))

