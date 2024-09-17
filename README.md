

# 🏨 MadPan Hotel Builder Plugin

**MadPan** is a Minecraft plugin designed to automatically build multi-story hotels with customized rooms, furnished interiors, and more. Whether you're hosting a server or simply looking to enhance your Minecraft world, **MadPan** will help you add elegant hotels to your world in no time!



## 🏗️ Plugin Features

- **Hotel Construction**: Automatically build a multi-floor hotel with one command or wand click.
- **Pre-furnished Rooms**: Each room comes equipped with beds, furnaces, chests, and crafting tables.
- **Redstone Carpet Entrance**: Adds a redstone block carpet at the entrance to symbolize a red carpet.
- **Windows and Doors**: Every room has windows to the outside and doors leading to a central corridor.
- **Diagonal Staircases**: Easily navigate between floors using built-in staircases.
- **Customization**: Add your own designs or modify the rooms and lobby to suit your style.
  
## 📂 File Structure

The project includes multiple components to build and manage the hotel:

```bash
MadPan/
├── .idea/                        # Project metadata
├── src/
│   └── main/
│       └── java/
│           └── antot_12/
│               └── madpan/
│                   ├── Plugin/               # Compiled plugin file
│                   ├── CooldownManager.java  # Manages cooldowns for hotel building
│                   ├── EntranceBuilder.java  # Handles the creation of the hotel entrance
│                   ├── EventListeners.java   # Handles player events and interactions
│                   ├── FloorBuilder.java     # Builds the individual floors of the hotel
│                   ├── FurnitureBuilder.java # Handles furniture placement in rooms
│                   ├── HotelBuilder.java     # Main class to manage the hotel creation
│                   ├── MadPan.java           # Plugin core logic
│                   ├── RoofBuilder.java      # Builds the roof of the hotel
│                   ├── StairBuilder.java     # Adds staircases between floors
│                   └── WandManager.java      # Manages the building wand mechanics
├── resources/
│   └── plugin.yml  # Plugin metadata and configuration
├── target/         # Compiled output and libraries
└── pom.xml         # Maven configuration file
```

## 🚀 Installation

1. Download the latest version of the **MadPan** plugin.
2. Place the `MadPan.jar` file into your Minecraft server's `plugins` directory.
3. Restart the server and ensure the plugin loads without errors.
4. To start building hotels, use the `/buildhotel` command or use the custom wand for building.

## 🔧 Commands

- `/buildhotel`: Build a hotel at the block you're pointing at.
- `/setwand`: Assign a wand that triggers hotel building.

## 🎨 Customization

The plugin is highly customizable and can be extended:
- **Room Layout**: Modify room and corridor layouts in `FloorBuilder.java` and `HotelBuilder.java`.
- **Furniture and Decoration**: Customize the types of furniture added to each room in `FurnitureBuilder.java`.
- **Lobby Design**: Change the look and feel of the lobby by editing `LobbyBuilder.java`.

## 🌱 Contributing

We welcome contributions! If you'd like to:
- Add features (e.g., more room designs, customization options)
- Fix bugs or improve performance
- Provide feedback or new ideas

Feel free to submit a pull request or open an issue in the [GitHub repository](#). We are especially looking for contributors to help with optimizations and localization to support multiple languages.

## 🙌 Support & Enhancements

We're actively developing and maintaining **MadPan**. Future plans include:
- More hotel styles and themes
- Room management systems (for renting, assigning, etc.)
- Expanded customization options for room and floor layout

If you'd like to support the project:
- ⭐ Star this repository
- 🗣 Spread the word by sharing the plugin
- 💬 Provide feedback and suggestions to improve it

---

Enhance your Minecraft world with **MadPan** and build luxurious hotels in minutes. Enjoy all the fun of building without the time-consuming effort. Happy building! 🏗️
