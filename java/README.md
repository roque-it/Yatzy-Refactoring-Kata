Sébastien Lamps 's logs:

As I don't know if this library is used by an application in production, I'm refactoring the code in keeping constraints:
- keep the java version (version 11)
- keep the interface name ("Yatzy"), interface contract (used in tests), and its class location (root)'
- keep the existing unit tests as they are

Step 1: format, clean and rearrange code for a better understanding (using editorconfig)
Step 2: split project to decouple legacy API contract from the new API (see constraints above)
Step 3: split code to decouple legacy API contract from the new API (in creating a "bridge" to the new API)
Step 4: homogenize methods parameters in introducing a transport object
