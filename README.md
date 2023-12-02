## Betting App

Betting App is a compact showcase project illustrating modern Android development practices using Kotlin, Jetpack Compose, and an MVI (Model-View-Intent) architecture. This demo project harnesses the power of Kotlin flows, Dagger Hilt for Dependency Injection, and Retrofit for network interactions.

### Key Features:

- **MVI Architecture**: Designed to seamlessly track data state changes and their impact on the UI, ensuring a smooth user experience.
  
- **Modularized Structure**: Data flow is streamlined from the data layer through the domain layer, housing use cases, and then onto the UI layer for a clear and organized architecture.

- **Reusable Design System**: Centralizes UI elements within a design system module, fostering reusability across the entire app.

- **Network Module**: Manages remote data fetching while orchestrating data via data sources and repositories, optimizing data handling.

- **Scalable Offline Functionality**: The architecture allows for the integration of additional features, such as a Room database, enabling offline capabilities by incorporating multiple data sources.

- **Version Catalog Integration**: Efficiently manages Gradle dependencies for smoother project maintenance and updates.

- **Adaptability**: Ensured functionality across multiple screen sizes and landscape orientation for a seamless user experience.

- **Testing Suite**: Includes illustrative unit and UI tests, serving as examples for testing strategies and best practices.

### Video Preview
https://github.com/mikekorel/BettingApp/assets/113293868/39b3d247-dfc8-40e9-8617-2c4fd1573938

This project is intended as a learning resource and a blueprint for integrating various Android development techniques in a concise manner.
