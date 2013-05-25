echo "Main-Class: Game" > data/Manifest.txt
jar cfm ../SlimeRun.jar data/Manifest.txt *.class data images audio
jar cfm SlimeRun.jar data/Manifest.txt *.class data images audio
#/* images/* images/back/* images/blocks/* images/green/slime.png
