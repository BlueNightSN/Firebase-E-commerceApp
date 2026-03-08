# Firebase E-commerce App Repository

## Overview
This repository contains an Android e-commerce sample project that integrates Firebase Authentication and Cloud Firestore for user management and cart/product data.

The main project is located in [`Matala3/`](Matala3/).

## Repository Structure
- `Matala3/` — Android Studio/Gradle project (application module + Firebase integration).
- `Matala3/app/` — Android application module source code, layouts, navigation graph, and Firebase config.

## Technologies
- Android (Java, AndroidX)
- Gradle (Kotlin DSL + version catalogs)
- Firebase Authentication
- Firebase Cloud Firestore
- Android Navigation Component
- RecyclerView / Material Components

## How to Run
1. Open `Matala3/` in Android Studio.
2. Ensure a valid Firebase project is configured in `app/google-services.json`.
3. Sync Gradle and run on an emulator/device (Android API 24+).

Or via CLI from `Matala3/`:
```bash
bash ./gradlew assembleDebug
```

## Example Usage
1. Register a new user account.
2. Sign in.
3. Open the product list and tap a product to add it to cart.
4. Return to home to view user details and cart contents.

## Roadmap
- Product image support
- Checkout flow and order history
- Firestore security rules hardening
- Better cart state synchronization and loading states
