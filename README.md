# Rebreather Goggles

A NeoForge mod for Minecraft 1.21.1 (NeoForge `21.1.176`) — the same versions used by the **All the Mods 10** modpack.

> **Heads up:** this mod was built with Claude Code — code, textures, and all. Yes, this is AI slop. It works and it's been tested in-game, but don't expect hand-crafted pixel art or a human-reviewed codebase behind it. This is my introduction to Minecraft modding, and purely a learning experience.

A helmet-slot diving mask: grants water breathing and night vision the entire time it's worn, on land or underwater. It only spends durability while the wearer is fully submerged, so surface use is free.

## How it works

- **Effects**: while worn in the helmet slot, grants continuous Water Breathing and Night Vision — no need to resurface to keep them topped up.
- **Durability**: loses 1 durability point per second, but only while the wearer is fully submerged. A full charge (900 durability) is good for about 15 minutes of underwater time.
- **Look**: rendered as a white strap holding two goggle lenses and a rebreather grille, not a full head-covering helmet — your character's head/hair still shows.

## Crafting

```
G I G
I C I
L L L
```
`G` = Glass Pane, `I` = Iron Ingot, `C` = Copper Ingot, `L` = Leather → 1× Rebreather Helmet

## Compatibility

Built against NeoForge `21.1.176` for Minecraft `1.21.1`. Works as a plain NeoForge mod on both dedicated servers and client instances (including modpacks like ATM10) — no other mod dependencies.

## Building

Requires JDK 21 (Gradle itself can be run with JDK 17+; NeoGradle provisions a JDK 21 toolchain automatically for compiling/running the mod).

```
./gradlew build
```

The output jar is written to `build/libs/`.

## Development

```
./gradlew runServer   # dedicated server, headless
./gradlew runClient   # client with the mod loaded
./gradlew runData     # data generation (if/when generators are added)
```

## License

MIT — see [LICENSE](LICENSE).
