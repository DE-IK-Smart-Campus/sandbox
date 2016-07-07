# Sandbox XMPP - Smack API and Java EE
---------------
Android: `Gradle` 

Java EE: `Maven` 

Az alkalmazás működéséhez szükséged van egy XMPP szerverre, [Ignite Realtime OpenFire Server](http://www.igniterealtime.org/projects/openfire/). Ezt ajánlom, könnyű telepíteni azután egyből használható is.

Ha leklónoztad a repót akkor utána az src/main/assets mappában találsz egy properti fájlt amit az OpenFire telepítése után el kell végezni hogy amikor majd buildeled az appot a megfelelő helyre csatlakozzon.

Android alkalmazás telepítéséhez szükséges a telefonon az ADB engedélyezése.
Ahhoz hogy fel tudd tenni a telefonra szükséged lesz a Gradle-re (Google).
Mappájában kell egy `gradle build` aztán amint a telefont USB-vel csatlakoztattad `gradle installDebug`.

A működés nagyon egyszerű.
Felhasználónév/jelszóval belépsz és utána pedig a megfelelő embernek tudsz üzenetet küldeni (fogadni még nem :'( ).

Java EE - szolgáltatás rész: ASAP
