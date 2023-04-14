# 2. feladat
Létrehoztam a feature_reference_speed_controlling branch-et a viselkedés megvalósításához. Ezután elkészítettem a saját implementációt, amely a java Thread osztályt használja.

# 2.1. feladat
![](f2_2.png)
A megoldásomhoz készítettem egy segéd metódust, amelyben egy while ciklusban 500 ms időközönként megváltoztatom a referencia sebességet a beállított joystick beállításával. Illetve lekezelem, hogy ne menjem a megendegett határ felé, ezt az erre már megírt metódussal értem el.

![](f2_3.png)
Készítettem egy pull requestet és közben kiderült a számomra, hogy a korábbi laboron a tachográf tesztjében benne maradt egy olyan viselkedés, ami még a régi referenciasebesség működését használta ki, de ezt kijavítottam és így már a korábbi teszteken át ment a megírt kódom.

![](f2_4.png)
Egy másik github-os felhasználomról elkészítettem egy változtatási lehetőséget.

![](f2_7.png)
Elvégeztem a módosítást majd commitoltam azt, ezután pedig a másik fiókomról Approve-oltam a változtatást. Ezek után merge-ltem a változtatást és töröltem a létrehozott feature branch-et.

# 2.2. feladat
![](f2_sonar.png)
A Sonarlint segítségével több hibát is találtam. Az egyik ilyen, amit a kép is mutat, amely arra hívja fel helyesen a figyelmet, hogy privát user tagváltozó nincs használatban, ez teljesen igaz, mert alapvetően sosem lehet lekérdezni, és csak a konsruktor állítja be az értékét, de utána semmilyen metódus nem használja.

![](f2_sonar_2.png)
Illetve az újonnan bevitt változtatásban is talált hibákat, amelyek jogosnak tűnnek a hozzájuk leírt szabályok alapján.

# 2.3. feladat
![](f2_3.png)
A leírtak szerint elkészítettem a SonarCloudos összekapcsolást és megadott helyeken elvégeztem a módosításokat. Ennek megfelelően a SonarCloud oldalán megtaláltam az általam készített snapshotot, amelyet a kép is mutat.