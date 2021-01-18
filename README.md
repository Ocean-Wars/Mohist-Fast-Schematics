# Mohist-Schematics

## Why to use this?

This plugin is usefull only in the case that you want to transfer some map parts from a modded mohist server to another. It will create schematics
that are compatible with modded servers (contrary to worldedit which completly breaks block ids).

If you just want to do simple copy and paste things inside of your server, I recommand worldedit or FastAsyncWorldedit.

## Why I made this plugin?

I have tried to copy and paste my spawn from my old server to new server. But every block was different and even some blocks disapeared.

Which I think is due to the fact that the main maps are different:

If you try to load a map with modded blocks inside which has a different main world than your actual main world (with mv import), all ids will change.

That is due to the fact that minecraft only store integer id of blocks, which are by the way deprecated in spigot. Since integer id of blocks differs from a modded server
to another moded server (due to main map difference). Then it mean that if you try to copy paste with schematics, you will get different outputs.

Thats why I made this plugin: It allows you to create schematics that store the material value of a block instead of the id of it.

## How to install?

Download it on the release corner at right or here is the link: [v1.0.0](https://github.com/Ocean-Wars/Mohist-Schematics/releases/tag/v1.0.0), download it and put it inside of your plugin folder.

## How to use this plugin?

### Area selection:

Run:
> /mcopy pos1
> /mcopy pos2

To set your pos1 and pos2 of your selection. It sets the position below your feets.

### Save a schematic

To save your schematics run
> /mcopy save "filename"

It will create a "mohistschematic" (extension .mschematics) at path pluginfolder/mohistschematics/schematics/filename.mschematics.

### Paste your schematic

To paste your schematic run
> /mcopy load "filename"

Then
> /mcopy paste

To paste your file.


## Contributing

Feel free to contribute to this repository if you want :)

I made this plugin only to paste my spawn but there could be some improvements that can be made:

* Improve the speed: Currently this plugin can paste up to 60k blocks per second, with some methods described there: [https://www.spigotmc.org/threads/methods-for-changing-massive-amount-of-blocks-up-to-14m-blocks-s.395868/](https://www.spigotmc.org/threads/methods-for-changing-massive-amount-of-blocks-up-to-14m-blocks-s.395868/)
it can maybe be faster :) You can optimized the fonction "paste" of MSchematicData
* Add some "axe" selection that would allow you to left click and right click on blocks that you want to copy and paste.
